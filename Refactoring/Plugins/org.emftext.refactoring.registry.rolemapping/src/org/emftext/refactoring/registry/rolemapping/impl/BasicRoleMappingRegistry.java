package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
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
	}

	public Map<String, RoleMappingModel> getRoleMappingMap() {
		return roleMappingMap;
	}
}
