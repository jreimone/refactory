package org.ontomore.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.owl.OwlPackage;
import org.emftext.language.owl.resource.owl.mopp.OwlMetaInformation;
import org.emftext.language.owl.resource.owl.mopp.OwlResourceFactory;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.ontomore.util.modelProvider.RefSpecProvider;
import org.ontomore.util.modelProvider.RoleMappingModelProvider;
import org.ontomore.util.modelProvider.RoleModelProvider;

/**
 * Wraps the Refactory-API. Provides functions for registering various models
 * and refactoring a model.
 * 
 * @author Erik Tittel
 */
public class RefactoryUtil {

	private static RefactoryUtil uniqueInstance = null;
	private IRoleModelRegistry roleModelRegistry = IRoleModelRegistry.INSTANCE;
	private IRefactoringSpecificationRegistry refSpecRegistry = IRefactoringSpecificationRegistry.INSTANCE;
	private IRoleMappingRegistry roleMappingRegistry = IRoleMappingRegistry.INSTANCE;

	public static RefactoryUtil getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new RefactoryUtil();
		}
		return uniqueInstance;
	}

	private RefactoryUtil() {
		registerOWLMetamodel();
		registerAllKnownModels();
	}

	private void registerOWLMetamodel() {
		EPackage.Registry.INSTANCE.put(OwlPackage.eNS_URI, OwlPackage.eINSTANCE);
		Map<String, Object> extensionToFactoryMap = Resource.Factory.Registry.INSTANCE
				.getExtensionToFactoryMap();
		extensionToFactoryMap.put(new OwlMetaInformation().getSyntaxName(),
				new OwlResourceFactory());
	}

	public void registerRoleModel(RoleModel roleModel) {
		try {
			if (!isRoleModelAlreadyRegistered(roleModel)) {
				roleModelRegistry.registerRoleModel(roleModel);
			}
		} catch (RoleModelAlreadyRegisteredException e) {
			System.out.println("Could not register RoleModel " + roleModel.getName());
		}
	}

	public boolean isRoleModelAlreadyRegistered(RoleModel roleModel) {
		RoleModel existingRoleModel = roleModelRegistry.getRoleModelByName(roleModel.getName());
		return existingRoleModel != null;
	}

	public void registerRefSpec(RefactoringSpecification refSpec) {
		try {
			if (!isRefSpecAlreadyRegistered(refSpec)) {
				refSpecRegistry.registerRefSpec(refSpec);
			}
		} catch (RefSpecAlreadyRegisteredException e) {
			System.out.println("Could not register RefSpec for RoleModel "
					+ refSpec.getUsedRoleModel().getName());
		}
	}

	public boolean isRefSpecAlreadyRegistered(RefactoringSpecification refSpec) {
		return isRefSpecAlreadyRegistered(refSpec.getUsedRoleModel().getName());
	}

	private boolean isRefSpecAlreadyRegistered(String refSpecName) {
		boolean result = false;
		for (RefactoringSpecification registeredRefSpec : refSpecRegistry.getAllRefSpecs()) {
			if (refSpecName.equals(registeredRefSpec.getUsedRoleModel().getName())) {
				result = true;
			}
		}
		return result;
	}

	public void registerRoleMappingModel(RoleMappingModel mappingModel) {
		if (!isRoleMappingModelAlreadyRegistered(mappingModel)) {
			try {
				roleMappingRegistry.registerRoleMappingModel(mappingModel);
			} catch (Exception e) {
				throw new RuntimeException(
						"The Rolemapping "
								+ mappingModel.eResource().getURI()
								+ " could not be registered. Make sure RoleModel and RefSpec are properly registered.",
						e);
			}
		}
	}

	/**
	 * Checks whether all RoleMappings of the RoleMappingModel are already
	 * registered.
	 */
	public boolean isRoleMappingModelAlreadyRegistered(RoleMappingModel mappingModel) {
		String metamodel = mappingModel.getTargetMetamodel().getNsURI().toString();
		Map<String, RoleMapping> roleMappingsForMetamodel = getNameRoleMappingMapForRegisteredMappings(metamodel);
		for (RoleMapping mapping : mappingModel.getMappings()) {
			String mappingName = mapping.getName();
			if (!roleMappingsForMetamodel.keySet().contains(mappingName)) {
				return false;
			}
		}
		return true;
	}

	private Map<String, RoleMapping> getNameRoleMappingMapForRegisteredMappings(String metamodel) {
		Map<String, RoleMapping> nameRoleMappingMap = roleMappingRegistry
				.getRoleMappingsForUri(metamodel);
		if (nameRoleMappingMap == null) {
			nameRoleMappingMap = Collections.emptyMap();
		}
		return nameRoleMappingMap;
	}

	public void registerAllKnownModels() {
		for (RoleModelProvider roleModelEnum : RoleModelProvider.values()) {
			registerRoleModel(roleModelEnum.toModel());
		}
		for (RefSpecProvider refSpecEnum : RefSpecProvider.values()) {
			registerRefSpec(refSpecEnum.toModel());
		}
		for (RoleMappingModelProvider roleMappingModelEnum : RoleMappingModelProvider.values()) {
			registerRoleMappingModel(roleMappingModelEnum.toModel());
		}
	}
	
	/**
	 * Actually executes an refactoring with Refactory.
	 */
	public EObject refactorModel(InputData input) {
		checkIfRefactoryModelsAreRegistered(input.mapping);
		RoleMapping roleMapping = getRoleMappingFromRefactorer(input);
		IRefactorer refactorer = getRefactorerForModel(input.model, roleMapping);
		List<EObject> inputElements = input.inputElements;
		refactorer.setInput(inputElements);
		IValueProviderFactory providerFactory = setInputValue(roleMapping, input.inputValues);
		refactorer.setValueProviderFactory(providerFactory);
		EObject refactoredModel = refactorer.refactor();
		if (refactoredModel == null) {
			throw new RuntimeException("Refactoring on model " + input.model.eResource().getURI()
					+ "wasn't successful");
		}
		return refactoredModel;
	}

	private void checkIfRefactoryModelsAreRegistered(RoleMapping roleMapping) {
		// FIXME fix proxy resolution
		if (roleMapping.eIsProxy()) {
			throw new RuntimeException(
					"Could not check whether models are registered because Proxy of RoleMapping could not be resolved "
							+ roleMapping);
		}
		RoleMappingModel roleMappingModel = roleMapping.getOwningMappingModel();
		if (!isRoleMappingModelAlreadyRegistered(roleMappingModel))
			throw new RuntimeException("RoleMappingModel for RoleMapping " + roleMapping.getName()
					+ " has to be registered prior to refactoring");
		RoleModel roleModel = roleMapping.getMappedRoleModel();
		if (!isRoleModelAlreadyRegistered(roleModel))
			throw new RuntimeException("RoleModel " + roleModel.getName() + " for RoleMapping "
					+ roleMapping.getName() + " has to be registered prior to refactoring");
		if (!isRefSpecAlreadyRegistered(roleModel.getName()))
			throw new RuntimeException("RefSpec " + roleModel.getName() + " for RoleMapping "
					+ roleMapping.getName() + " has to be registered prior to refactoring");
	}

	private IValueProviderFactory setInputValue(RoleMapping roleMapping, List<String> inputValues) {
		TestAttributeValueProvider valueProvider = new TestAttributeValueProvider(inputValues.get(0));
		// When ValueProvider isn't set, a dialogue pops up asking for the input
		// value.
		// ASSIGNInterpreter.setValueProvider(TestAttributeValueProvider.class);
		IValueProviderFactory valueProviderFactory = new TestValueProviderFactory(valueProvider);
		return valueProviderFactory;
	}

	/**
	 * It is necessary to get the RoleMapping from the Refactorer that should
	 * actually be the same as the given RoleMapping (it has at least the same
	 * name). Otherwise the Refactorer returns null instead of the refactored
	 * model.
	 * 
	 */
	private RoleMapping getRoleMappingFromRefactorer(InputData input) {
		List<RoleMapping> roleMappings = IRoleMappingRegistry.INSTANCE.getPossibleRoleMappingsForResource(input.model.eResource(), input.inputElements, 1.0);
		RoleMapping chosenRoleMapping = null;
		for (RoleMapping roleMappingFromRefactorer : roleMappings) {
			if (input.mapping.getName().equals(roleMappingFromRefactorer.getName())) {
				chosenRoleMapping = roleMappingFromRefactorer;
				break;
			}
		}
		if (chosenRoleMapping == null) {
			throw new RuntimeException("The RoleMapping " + input.mapping.getName()
					+ " isn't applicable for the Model " + input.model + " and input element "
					+ input.inputElements);
		}
		return chosenRoleMapping;
	}

	public IRefactorer getRefactorerForModel(EObject model, RoleMapping roleMapping) {
		RefactorerFactory refactorerFactory = RefactorerFactory.eINSTANCE;
		IRefactorer refactorer = refactorerFactory.getRefactorer(model.eResource(), roleMapping);
		if (refactorer == null) {
			throw new RuntimeException(
					"The refactorer could not be initialised. This happends when no rolemappings are registered to the metamodel of the given model.");
		}
		return refactorer;
	}
}
