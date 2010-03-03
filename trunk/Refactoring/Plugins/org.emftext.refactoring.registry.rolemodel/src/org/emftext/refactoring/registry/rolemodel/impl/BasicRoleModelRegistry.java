package org.emftext.refactoring.registry.rolemodel.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.Activator;
import org.emftext.refactoring.registry.rolemodel.IRoleModelExtensionPoint;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;

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
		ResourceSet rs = new ResourceSetImpl();
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(IRoleModelExtensionPoint.ID);
		for (IConfigurationElement element : elements) {
			String value = element.getAttribute(IRoleModelExtensionPoint.RESOURCE_ATTRIBUTE);
			String plugin = element.getContributor().getName();
			URI uri = URI.createPlatformPluginURI("/" + plugin + "/" + value, true);
			Resource resource = null;
			try{
				resource = rs.getResource(uri, true);
			} catch (Exception e) {
				Activator.getDefault().log(String.format("Resource '%1$s' couldn't be loaded", value), IStatus.ERROR);
				continue;
			}
			if(resource == null){
				Activator.getDefault().log(String.format("Resource '%1$s' couldn't be loaded", value), IStatus.ERROR);
				continue;
			}
			EObject model = resource.getContents().get(0);
			if(model instanceof RoleModel){
				try {
					registerRoleModel((RoleModel) model);
				} catch (RoleModelAlreadyRegisteredException e) {
					Activator.getDefault().log(String.format("A RoleModel with name '%1$s' was already registered", e.getRoleModel().getName()), IStatus.ERROR);
				}
			} else {
				Activator.getDefault().log(String.format("The resource with URI '%1$s' doesn't contain a RoleModel", uri.toString())
						, IStatus.ERROR);
			}
		}
	}
}
