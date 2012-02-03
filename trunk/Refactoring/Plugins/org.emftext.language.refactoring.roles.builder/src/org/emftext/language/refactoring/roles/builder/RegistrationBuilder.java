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
package org.emftext.language.refactoring.roles.builder;

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
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.emftext.refactoring.util.RegistryUtil;

public class RegistrationBuilder implements IRolestextBuilder {

	public IStatus build(RolestextResource resource, IProgressMonitor monitor) {
		RoleModel model = (RoleModel) resource.getContents().get(0);
		try {
			IRoleModelRegistry.INSTANCE.registerRoleModel(model);
		} catch (RoleModelAlreadyRegisteredException e) {
			RegistryUtil.log("Role Model " + model.getName() + " already registered", IStatus.WARNING);
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

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
