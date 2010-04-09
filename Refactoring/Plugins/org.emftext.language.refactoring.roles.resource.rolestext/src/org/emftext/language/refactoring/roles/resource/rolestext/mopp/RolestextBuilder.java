/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;

public class RolestextBuilder implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBuilder {

	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource != null && (resource.getErrors() == null || resource.getErrors().size() == 0)){
			EObject root = resource.getContents().get(0);
			if(root instanceof RoleModel){
				RoleModel model = (RoleModel) root;
				String name = model.getName();
				RoleModel registeredModel = IRoleModelRegistry.INSTANCE.getRoleModelByName(name);
				if(registeredModel == null){
					return true;
				} else {
					if(registeredModel.eResource().getURI().equals(resource.getURI())){
						return true;
					}
				}
			}
		}
		return false;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		RoleModel model = (RoleModel) resource.getContents().get(0);
		try {
			if((resource.getErrors() == null || resource.getErrors().size() == 0)){
				IRoleModelRegistry.INSTANCE.registerRoleModel(model);
				resource.addWarning("This Role Model was only registered temporarily.\nYou should consider to register it as extension.", model);
			}
		} catch (RoleModelAlreadyRegisteredException e) {
			IRoleModelRegistry.INSTANCE.updateRoleModel(model);
			resource.addWarning("This Role Model was only registered temporarily.\nYou should consider to register it as extension.", model);
		}
		return Status.OK_STATUS;
	}

}
