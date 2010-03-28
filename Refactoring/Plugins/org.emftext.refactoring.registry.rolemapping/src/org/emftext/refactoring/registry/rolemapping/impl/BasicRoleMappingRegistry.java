package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.registry.rolemapping.IPostProcessorExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemapping.exceptions.RoleMappingAlreadyRegistered;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRoleMappingRegistry implements IRoleMappingRegistry {

	private Map<String, Map<String, Mapping>> roleMappingsMap;
	private Map<String, Map<Mapping, IRefactoringPostProcessor>> postProcessorMap;

	public BasicRoleMappingRegistry(){
		roleMappingsMap = new LinkedHashMap<String, Map<String, Mapping>>();
		postProcessorMap = new LinkedHashMap<String, Map<Mapping,IRefactoringPostProcessor>>();
		collectRegisteredRoleMappings();
		collectRegisteredPostProcessors();
	}

	public Map<String, Mapping> getRoleMappingsForUri(String nsUri) {
		return getRoleMappingsMap().get(nsUri);
	}

	private void collectRegisteredRoleMappings(){
		List<RoleMappingModel> models = RegistryUtil.collectRegisteredResources(IRoleMappingExtensionPoint.ID
				, IRoleMappingExtensionPoint.RESOURCE_ATTRIBUTE
				, RoleMappingModel.class);
		for (RoleMappingModel roleMapping : models) {
			registerRoleMapping(roleMapping);
		}
	}

	private void collectRegisteredPostProcessors(){
		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IPostProcessorExtensionPoint.ID);
		for (IConfigurationElement element : elements) {
			try {
				IRefactoringPostProcessor postprocessor = (IRefactoringPostProcessor) element.createExecutableExtension(IPostProcessorExtensionPoint.ATTRIBUTE_POST_PROCESSOR);
				String nsUri = element.getAttribute(IPostProcessorExtensionPoint.ATTRIBUTE_NS_URI);
				String mappingName = element.getAttribute(IPostProcessorExtensionPoint.ATTRIBUTE_MAPPING);
				Map<String, Mapping> roleMappings = getRoleMappingsForUri(nsUri);
				Mapping mapping = null;
				for (String registeredName : roleMappings.keySet()) {
					if(registeredName.equals(mappingName.trim())){
						mapping = roleMappings.get(registeredName);
						break;
					}
				}
				if(mapping == null){
					continue;
				}
				registerPostProcessor(mapping, postprocessor);
			} catch (CoreException e) {
				RegistryUtil.log("Could not instantiate postprocessor", IStatus.ERROR, e);
			}
		}
	}

	public void registerRoleMapping(RoleMappingModel roleMapping) {
		Map<String, Mapping> mappingsToRegister = new LinkedHashMap<String, Mapping>();
		for (Mapping mapping : roleMapping.getMappings()) {
			mappingsToRegister.put(mapping.getName(), mapping);
		}

		String nsUri = roleMapping.getTargetMetamodel().getNsURI();
		Map<String, Mapping> registered = getRoleMappingsMap().get(nsUri);
		if(registered == null){
			registered = new LinkedHashMap<String, Mapping>();
			getRoleMappingsMap().put(nsUri, registered);
		}
		for (String mappingName : mappingsToRegister.keySet()) {
			if(registered.get(mappingName) != null){
				RegistryUtil.log("A mapping '" + mappingName + "' already exists in the registry for metamodel " + nsUri, IStatus.WARNING);
			} else {
				registered.put(mappingName, mappingsToRegister.get(mappingName));
			}
		}
		EPackage rootPackage = roleMapping.getTargetMetamodel();
		registerSubPackages(rootPackage, roleMapping);
	}

	private void registerSubPackages(EPackage rootPackage, RoleMappingModel roleMapping){
		List<EPackage> subPackages = rootPackage.getESubpackages();
		if(subPackages != null){
			for (EPackage subpackage : subPackages) {
				String nsUri = subpackage.getNsURI();
				Map<String, Mapping> registered = getRoleMappingsMap().get(nsUri);
				if(registered != null){
					RegistryUtil.log("Metamodel " + nsUri + " already registered ", IStatus.WARNING);
				} else {
					getRoleMappingsMap().put(nsUri, registered);
					registerSubPackages(subpackage, roleMapping);
				}
			}
		}
	}

	public Map<String, Map<String, Mapping>> getRoleMappingsMap() {
		return roleMappingsMap;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#registerPostProcessor(org.emftext.language.refactoring.rolemapping.RoleMappingModel, org.emftext.language.refactoring.rolemapping.Mapping, org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor)
	 */
	public void registerPostProcessor(Mapping mapping, IRefactoringPostProcessor postProcessor) {
		RoleMappingModel root = (RoleMappingModel) EcoreUtil.getRootContainer(mapping);
		registerPostProcessor(root.getTargetMetamodel(), mapping, postProcessor);
		List<EPackage> subPackages = root.getTargetMetamodel().getESubpackages();
		for (EPackage subPackage : subPackages) {
			registerPostProcessor(subPackage, mapping, postProcessor);
		}
	}

	private void registerPostProcessor(EPackage metamodel, Mapping mapping, IRefactoringPostProcessor postProcessor) {
		String nsUri = metamodel.getNsURI();
		Map<Mapping, IRefactoringPostProcessor> map = postProcessorMap.get(nsUri);
		if(map == null){
			map = new LinkedHashMap<Mapping, IRefactoringPostProcessor>();
		}
		map.put(mapping, postProcessor);
		postProcessorMap.put(nsUri, map);
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#getPostProcessor(org.eclipse.emf.ecore.EPackage, org.emftext.language.refactoring.rolemapping.Mapping)
	 */
	public IRefactoringPostProcessor getPostProcessor(EPackage metamodel, Mapping mapping) {
		String nsUri = metamodel.getNsURI();
		Map<Mapping, IRefactoringPostProcessor> map = postProcessorMap.get(nsUri);
		if(map == null){
			return null;
		}
		return map.get(mapping);
	}
}
