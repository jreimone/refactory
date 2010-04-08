package org.emftext.language.refactoring.roles.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBuilder;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;

public class RegistrationBuilder implements IRolestextBuilder {

	public IStatus build(RolestextResource resource, IProgressMonitor monitor) {
		RoleModel model = (RoleModel) resource.getContents().get(0);
		try {
			IRoleModelRegistry.INSTANCE.registerRoleModel(model);
		} catch (RoleModelAlreadyRegisteredException e) {
			// TODO dialog to user (or log entry) that role model already exists
			System.out.println("already exists");
		}
		return null;
	}

	public boolean isBuildingNeeded(URI uri) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource != null){
			EObject root = resource.getContents().get(0);
			if(root instanceof RoleModel){
				RoleModel model = (RoleModel) root;
				String name = model.getName();
				if(IRoleModelRegistry.INSTANCE.getRoleModelByName(name) == null){
					return true;
				}
			}
		}
		return false;
	}

}
