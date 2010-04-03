package org.emftext.refactoring.registry.rolemodel.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.Activator;
import org.emftext.refactoring.registry.rolemodel.IRoleModelExtensionPoint;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRoleModelRegistry implements IRoleModelRegistry {

	private Map<String, RoleModel> roleModelNameMap;

	public BasicRoleModelRegistry(){
		roleModelNameMap = new HashMap<String, RoleModel>();
		collectRegisteredRoleModels();
	}

	public Collection<RoleModel> getAllRegisteredRoleModels() {
		return roleModelNameMap.values();
	}

	public RoleModel getRoleModelByName(String name) {
		return getRoleModelNameMap().get(name);
	}


	public Map<String, RoleModel> getRoleModelNameMap() {
		return roleModelNameMap;
	}

	public void registerRoleModel(RoleModel roleModel) throws RoleModelAlreadyRegisteredException {
		String name = roleModel.getName();
		RoleModel registeredModel = getRoleModelNameMap().get(name);
		if(registeredModel != null){
			throw new RoleModelAlreadyRegisteredException(roleModel);
		}
		getRoleModelNameMap().put(name, roleModel);
	}

	private void collectRegisteredRoleModels(){
		Map<RoleModel, IConfigurationElement> models = RegistryUtil.collectRegisteredResources(IRoleModelExtensionPoint.ID
				, IRoleModelExtensionPoint.RESOURCE_ATTRIBUTE
				, RoleModel.class);
		for (RoleModel roleModel : models.keySet()) {
			try {
				registerRoleModel(roleModel);
			} catch (RoleModelAlreadyRegisteredException e) {
				Activator.getDefault().log(e.getMessage(), IStatus.ERROR);
			}
		}
	}
}
