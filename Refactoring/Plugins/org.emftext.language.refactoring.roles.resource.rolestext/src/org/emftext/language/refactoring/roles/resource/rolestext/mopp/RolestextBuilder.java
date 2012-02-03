/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBuilder;
import org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;

public class RolestextBuilder implements IRolestextBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
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
	
	public IStatus build(RolestextResource resource, IProgressMonitor monitor) {
		RoleModel model = (RoleModel) resource.getContents().get(0);
		try {
			if((resource.getErrors() == null || resource.getErrors().size() == 0)){
				IRoleModelRegistry.INSTANCE.registerRoleModel(model);
				resource.addWarning("This Role Model was only registered temporarily.\nYou should consider to register it as extension.", RolestextEProblemType.BUILDER_ERROR, model);
			}
		} catch (RoleModelAlreadyRegisteredException e) {
			IRoleModelRegistry.INSTANCE.updateRoleModel(model);
			resource.addWarning("This Role Model was only registered temporarily.\nYou should consider to register it as extension.", RolestextEProblemType.BUILDER_ERROR, model);
		}
		return Status.OK_STATUS;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
