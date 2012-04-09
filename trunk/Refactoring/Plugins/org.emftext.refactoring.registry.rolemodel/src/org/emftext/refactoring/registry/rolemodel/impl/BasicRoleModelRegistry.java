/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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

	public void updateRoleModel(RoleModel model) {
//		RoleModel registeredModel = getRoleModelByName(model.getName());
		getRoleModelNameMap().put(model.getName(), model);
	}
}
