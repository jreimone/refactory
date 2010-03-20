package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingExtensionPoint;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemapping.exceptions.RoleMappingAlreadyRegistered;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRoleMappingRegistry implements IRoleMappingRegistry {

	private Map<String, RoleMappingModel> roleMappingMap;
	
	public BasicRoleMappingRegistry(){
		roleMappingMap = new HashMap<String, RoleMappingModel>();
		collectRegisteredRoleModels();
	}
	
	public RoleMappingModel getRoleMappingForUri(String nsUri) {
		return getRoleMappingMap().get(nsUri);
	}
	
	private void collectRegisteredRoleModels(){
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
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#getPostProcessor(java.lang.String, java.lang.String)
	 */
	public IRefactoringPostProcessor getPostProcessor(String nsUri,
			String mappingName) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry#registerPostProcessor(org.emftext.language.refactoring.rolemapping.RoleMappingModel, org.emftext.language.refactoring.rolemapping.Mapping, org.emftext.refactoring.registry.rolemapping.IRefactoringPostProcessor)
	 */
	public void registerPostProcessor(RoleMappingModel roleMapping,
			Mapping mapping, IRefactoringPostProcessor postProcessor) {
		// TODO Auto-generated method stub
		
	}
}
