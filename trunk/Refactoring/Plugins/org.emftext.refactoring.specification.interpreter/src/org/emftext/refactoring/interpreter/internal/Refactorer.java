/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.indexconnector.IndexConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IRefactoringFakeInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.IRefactoringStatus;
import org.emftext.refactoring.interpreter.IValueProvider;
import org.emftext.refactoring.interpreter.RefactoringStatus;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;
import org.emftext.refactoring.util.RoleUtil;

/**
 * @author Jan Reimann
 *
 */
public class Refactorer implements IRefactorer {

	private EObject model;
	private Map<String, RoleMapping> roleMappings;
	private List<? extends EObject> currentSelection;
	private Map<RoleMapping, IRefactoringInterpreter> interpreterMap;
	private IRefactoringSpecificationRegistry refSpecRegistry;
	private IRoleMappingRegistry roleMappingRegistry;
	private boolean occuredErrors;
	private List<Resource> resourcesToSave;
	private Resource resource;
	private IRefactoringStatus status;
	private RoleMapping currentMapping;
	private IRefactoringInterpreter currentInterpreter;
	private List<? extends EObject> currentFilteredSelection;
	private ResourceSet currentModelResourceSet;
	private EObject fakeRefactoredModel;

	public Refactorer(Resource resource, Map<String, RoleMapping> roleMappings) {
		this.resource = resource;
		this.model = resource.getContents().get(0);
		this.roleMappings = roleMappings;
		refSpecRegistry = IRefactoringSpecificationRegistry.INSTANCE;
		roleMappingRegistry = IRoleMappingRegistry.INSTANCE;
		initInterpreterMap();
	}

	private void initInterpreterMap() {
		interpreterMap = new LinkedHashMap<RoleMapping, IRefactoringInterpreter>();
		Collection<RoleMapping> mappings = roleMappings.values();
		for (RoleMapping mapping : mappings) {
			RoleModel roleModel = mapping.getMappedRoleModel();
			EcoreUtil.resolveAll(roleModel);
			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(roleModel);
//			RoleMapping firstMapping = roleMappings.values().toArray(new RoleMapping[0])[0];
//			RoleMappingModel roleMapping = (RoleMappingModel) EcoreUtil.getRootContainer(firstMapping);
			IRefactoringPostProcessor postProcessor = roleMappingRegistry.getPostProcessor(mapping);
			IRefactoringInterpreter interpreter = new RefactoringInterpreter(postProcessor);
			interpreter.initialize(refSpec, mapping);
			interpreterMap.put(mapping, interpreter);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings()
	 */
	public List<RefactoringSpecification> getPossibleRefactoringsForNearestRoleModels(double minEquality) {
		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
		List<RoleMapping> possibleMappings = RoleUtil.getPossibleMappingsForSelection(currentSelection, roleMappings, minEquality);
		for (RoleMapping mapping : possibleMappings) {
			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(mapping.getMappedRoleModel());
			if (refSpec != null) {
				refSpecs.add(refSpec);
			}
		}
		return refSpecs;
	}

	public IRefactoringFakeInterpreter fakeRefactor(RoleMapping mapping) {
		if (mapping == null) {
			currentMapping = null;
			return null;
		}
		currentMapping = mapping;
		currentFilteredSelection = filterSelectedElements(mapping);
		currentInterpreter = interpreterMap.get(mapping);

		if (currentInterpreter != null && currentFilteredSelection.size() > 0) {
			List<Resource> allReferencingResources = IndexConnectorRegistry.INSTANCE.getReferencingResources(model);
			currentModelResourceSet = getResource().getResourceSet();
			for (Resource resource : allReferencingResources) {
				URI uri = resource.getURI();
				currentModelResourceSet.getResource(uri, true);
			}
			// can be used for displaying a comparison with 'model'
			return fakeInterpreteAndPreCollectValues(currentFilteredSelection, currentInterpreter, currentModelResourceSet);
		} else {
			return null;
		}
	}

	public EObject getFakeRefactoredModel() {
		return fakeRefactoredModel;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#refactor(org.emftext.
	 * language.refactoring.refactoring_specification.RefactoringSpecification,
	 * boolean)
	 */
	public EObject refactor() {
		if (currentMapping == null || currentInterpreter == null || currentFilteredSelection.size() == 0 || currentModelResourceSet == null) {
			return null;
		}
		EObject refactoredModel = realInterprete(currentMapping, currentFilteredSelection, currentInterpreter, currentModelResourceSet);
		return refactoredModel;
	}

	/**
	 * @param mapping
	 * @param filteredElements
	 * @param interpreter
	 * @param refactoredModelRS
	 * @return
	 */
	private EObject realInterprete(RoleMapping mapping, List<? extends EObject> filteredElements, IRefactoringInterpreter interpreter, ResourceSet refactoredModelRS) {
		EObject refactoredModel;
		interpreter.setInput(filteredElements);
		ChangeRecorder recorder = new ChangeRecorder(refactoredModelRS);
		refactoredModel = interpreter.interprete(model);
		status = interpreter.getStatus();
		if (status.getSeverity() != IRefactoringStatus.OK) {
			return refactoredModel;
		}
		ChangeDescription change = recorder.summarize();
		occuredErrors = interpreter.didErrorsOccur();
		if (!occuredErrors) {
			IRefactoringPostProcessor postProcessor = interpreter.getPostProcessor();
			if (postProcessor != null) {
				RefactoringSpecification refactoringSpecification = interpreter.getRefactoringSpecification();
				IStatus postProcessingStatus = postProcessor.process(interpreter.getRoleRuntimeInstances(), refactoredModelRS, change, refactoringSpecification);
				if (postProcessingStatus.getSeverity() != IRefactoringStatus.OK) {
					int severity = postProcessingStatus.getSeverity();
					status = new RefactoringStatus(mapping, severity, postProcessingStatus.getMessage());
				}
			}
		}
		resourcesToSave = interpreter.getResourcesToSave();
		return refactoredModel;
	}

	public IRefactoringInterpreter getCurrentInterpreter() {
		return currentInterpreter;
	}

	/**
	 * @param filteredElements
	 * @param interpreter
	 * @param refactoredModelRS
	 */
	private IRefactoringFakeInterpreter fakeInterpreteAndPreCollectValues(List<? extends EObject> filteredElements, IRefactoringInterpreter interpreter, ResourceSet refactoredModelRS) {
		// TODO integrate and invoke post processor here, too, and pass value provider to it
		// copy init start
		Copier copier = new Copier(false, true);
		List<EObject> originalElements = new LinkedList<EObject>();
		// copy start
		for (Resource resource : refactoredModelRS.getResources()) {
			URI uri = resource.getURI();
			if (uri.isPlatformResource() || uri.isFile()) {
				for (EObject model : resource.getContents()) {
					originalElements.add(model);
				}
			}
		}
		Collection<EObject> copiedElements = copier.copyAll(originalElements);
		copier.copyReferences();
		List<EObject> copiedInputSelection = new LinkedList<EObject>();
		for (EObject eObject : filteredElements) {
			copiedInputSelection.add(copier.get(eObject));
		}
		EObject copiedModel = copier.get(model);
		interpreter.setInput(copiedInputSelection);
		ChangeRecorder recorder = new ChangeRecorder(refactoredModelRS);
		ChangeDescription change = recorder.summarize();
		IRefactoringFakeInterpreter fakeInterpreter = interpreter.getFakeInterpreter();
		fakeInterpreter.setInput(copiedInputSelection);
		EObject copiedRefactoredModel = null;
		try {
			// this model then can be used for compare view before refactoring
			copiedRefactoredModel = fakeInterpreter.interprete(copiedModel);
			change = recorder.summarize();
			//after interpreting and refactoring the generic part, the postprocessor is called here
			IRefactoringPostProcessor fakePostProcessor = fakeInterpreter.getPostProcessor();
			if (fakePostProcessor != null) {
				RefactoringSpecification fakeRefactoringSpecification = fakeInterpreter.getRefactoringSpecification();
				IStatus fakePostProcessingStatus = fakePostProcessor.process(fakeInterpreter.getRoleRuntimeInstances(), refactoredModelRS, change, fakeRefactoringSpecification);
				if (fakePostProcessingStatus.getSeverity() != IRefactoringStatus.OK) {
					int severity = fakePostProcessingStatus.getSeverity();
					IRefactoringStatus fakeRefStatus = new RefactoringStatus(currentMapping, severity, fakePostProcessingStatus.getMessage());
				}
			}
			//end of postprocessing
			
		} catch (Exception e) {
//			e.printStackTrace();
			RegistryUtil.log("fake interpreter threw exception", IStatus.ERROR, e);
			return fakeInterpreter;
		}
		// copy end
		List<IValueProvider<?, ?>> valueProviders = fakeInterpreter.getValuesToProvide();
		Map<EObject, EObject> inverseCopier = new LinkedHashMap<EObject, EObject>();
		for (EObject originalObject : copier.keySet()) {
			inverseCopier.put(copier.get(originalObject), originalObject);
		}
		List<IValueProvider<?, ?>> provideableValues = new LinkedList<IValueProvider<?, ?>>();
		for (IValueProvider<?, ?> valueProvider : valueProviders) {
			// check if value can be provided before Refactoring
			Object fakeObject = valueProvider.getFakeObject();
			if (fakeObject instanceof EStructuralFeature) {
				provideableValues.add(valueProvider);
			} else if (fakeObject instanceof EObject) {
				EObject realObject = inverseCopier.get(fakeObject);
				if (realObject != null) {
					provideableValues.add(valueProvider);
				}
			} else if (fakeObject instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<EObject> fakeObjects = (List<EObject>) fakeObject;
				boolean provideable = true;
				for (EObject object : fakeObjects) {
					EObject realObject = inverseCopier.get(object);
					if (realObject == null) {
						provideable = false;
						break;
					}
				}
				if (provideable) {
					provideableValues.add(valueProvider);
				}
			}
		}
		if (copiedRefactoredModel != null) {
			fakeRefactoredModel = copiedRefactoredModel;
		} else {
			fakeRefactoredModel = null;
		}
		fakeInterpreter.setProvideableValues(provideableValues);
		for (IValueProvider<?, ?> valueProvider : provideableValues) {
			valueProvider.setCopier(copier);
		}
		return fakeInterpreter;
	}

	private List<? extends EObject> filterSelectedElements(RoleMapping mapping) {
		List<EObject> filteredElements = RoleUtil.filterObjectsByInputRoles(currentSelection, mapping);
		List<EObject> elementsToRemove = new LinkedList<EObject>();
		for (EObject child : filteredElements) {
			List<EObject> othersList = new LinkedList<EObject>();
			for (EObject eObject : filteredElements) {
				if (!eObject.equals(child)) {
					othersList.add(eObject);
				}
			}
			for (EObject parent : othersList) {
				if (EcoreUtil.isAncestor(parent, child)) {
					elementsToRemove.add(child);
				}
			}
		}
		for (EObject child : elementsToRemove) {
			filteredElements.remove(child);
		}
		Collections.sort(filteredElements, new Comparator<EObject>() {

			public int compare(EObject o1, EObject o2) {
				EObject parent1 = o1.eContainer();
				EObject parent2 = o2.eContainer();
				if (parent1.equals(parent2)) {
					int index1 = ((List<?>) parent1.eGet(o1.eContainingFeature())).indexOf(o1);
					int index2 = ((List<?>) parent1.eGet(o2.eContainingFeature())).indexOf(o2);
					return index1 - index2;
				}
				return 0;
			}
		});
		return filteredElements;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#setInput(org.eclipse.
	 * emf.common.util.EList)
	 */
	public void setInput(List<? extends EObject> selectedElements) {
		currentSelection = selectedElements;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.emftext.refactoring.interpreter.IRefactorer#getPossibleRefactorings
	 * (double)
	 */
	public List<RefactoringSpecification> getPossibleRefactorings(double minEquality) {
		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
		List<RoleMapping> possibleMappings = RoleUtil.getPossibleMappingsForInputSelection(currentSelection, roleMappings, minEquality);
		for (RoleMapping mapping : possibleMappings) {
			RefactoringSpecification refSpec = refSpecRegistry.getRefSpec(mapping.getMappedRoleModel());
			if (refSpec != null) {
				refSpecs.add(refSpec);
			}
		}
		return refSpecs;
	}

	public List<RoleMapping> getPossibleRoleMappings(double minEquality) {
		return RoleUtil.getPossibleMappingsForInputSelection(currentSelection, roleMappings, minEquality);
	}

	/*
	 * (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#occuredErrors()
	 */
	public boolean didErrorsOccur() {
		return occuredErrors;
	}

	public List<Resource> getResourcesToSave() {
		return resourcesToSave;
	}

	public Resource getResource() {
		return resource;
	}

	/*
	 * (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.IRefactorer#getStatus()
	 */
	public IRefactoringStatus getStatus() {
		return status;
	}

	public EObject getOriginalModel() {
		return model;
	}
}
