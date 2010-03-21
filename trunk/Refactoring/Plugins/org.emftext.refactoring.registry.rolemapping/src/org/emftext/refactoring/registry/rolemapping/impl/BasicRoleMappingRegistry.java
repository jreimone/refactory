package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.registry.rolemapping.IPostProcessorExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemapping.exceptions.RoleMappingAlreadyRegistered;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRoleMappingRegistry implements IRoleMappingRegistry {

	private Map<String, RoleMappingModel> roleMappingMap;
	private Map<String, Map<Mapping, IRefactoringPostProcessor>> postProcessorMap;
	
	public BasicRoleMappingRegistry(){
		roleMappingMap = new LinkedHashMap<String, RoleMappingModel>();
		postProcessorMap = new LinkedHashMap<String, Map<Mapping,IRefactoringPostProcessor>>();
		collectRegisteredRoleMappings();
		collectRegisteredPostProcessors();
	}
	
	public RoleMappingModel getRoleMappingForUri(String nsUri) {
		return getRoleMappingMap().get(nsUri);
	}
	
	private void collectRegisteredRoleMappings(){
		List<RoleMappingModel> models = RegistryUtil.collectRegisteredResources(IRoleMappingExtensionPoint.ID
				, IRoleMappingExtensionPoint.RESOURCE_ATTRIBUTE
				, RoleMappingModel.class);
		for (RoleMappingModel roleMapping : models) {
			try {
				registerRoleMapping(roleMapping);
			} catch (RoleMappingAlreadyRegistered e) {
				RegistryUtil.log(e.getMessage(), IStatus.ERROR);
			}
		}
	}
	
	private void collectRegisteredPostProcessors(){
		IConfigurationElement[] elements = RegistryUtil.collectConfigurationElements(IPostProcessorExtensionPoint.ID);
		for (IConfigurationElement element : elements) {
			try {
				IRefactoringPostProcessor postprocessor = (IRefactoringPostProcessor) element.createExecutableExtension(IPostProcessorExtensionPoint.ATTRIBUTE_POST_PROCESSOR);
				String nsUri = element.getAttribute(IPostProcessorExtensionPoint.ATTRIBUTE_NS_URI);
				String mappingName = element.getAttribute(IPostProcessorExtensionPoint.ATTRIBUTE_MAPPING);
				RoleMappingModel roleMapping = getRoleMappingForUri(nsUri);
				Mapping mapping = null;
				for (Mapping tempMapping : roleMapping.getMappings()) {
					if(tempMapping.getName().equals(mappingName.trim())){
						mapping = tempMapping;
						break;
					}
				}
				if(mapping == null){
					continue;
				}
				registerPostProcessor(roleMapping, mapping, postprocessor);
			} catch (CoreException e) {
				RegistryUtil.log("Could not instantiate postprocessor", IStatus.ERROR, e);
			}
		}
	}

	public void registerRoleMapping(RoleMappingModel roleMapping) throws RoleMappingAlreadyRegistered {
		String nsUri = roleMapping.getTargetMetamodel().getNsURI();
		RoleMappingModel registered = getRoleMappingMap().get(nsUri);
		if(registered != null){
			throw new RoleMappingAlreadyRegistered(roleMapping);
		}
		getRoleMappingMap().put(nsUri, roleMapping);
		EPackage rootPackage = roleMapping.getTargetMetamodel();
		registerSubPackages(rootPackage, roleMapping);
	}

	private void registerSubPackages(EPackage rootPackage, RoleMappingModel roleMapping) throws RoleMappingAlreadyRegistered {
		List<EPackage> subPackages = rootPackage.getESubpackages();
		if(subPackages != null){
			for (EPackage subpackage : subPackages) {
				String nsUri = subpackage.getNsURI();
				RoleMappingModel registered = getRoleMappingMap().get(nsUri);
				if(registered != null){
					throw new RoleMappingAlreadyRegistered(roleMapping);
				}
				getRoleMappingMap().put(nsUri, roleMapping);
				registerSubPackages(subpackage, roleMapping);
			}
		}
	}

	public Map<String, RoleMappingModel> getRoleMappingMap() {
		return roleMappingMap;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#registerPostProcessor(org.emftext.language.refactoring.rolemapping.RoleMappingModel, org.emftext.language.refactoring.rolemapping.Mapping, org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor)
	 */
	public void registerPostProcessor(RoleMappingModel roleMapping, Mapping mapping, IRefactoringPostProcessor postProcessor) {
		registerPostProcessor(roleMapping.getTargetMetamodel(), mapping, postProcessor);
		List<EPackage> subPackages = roleMapping.getTargetMetamodel().getESubpackages();
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
