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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.Activator;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistryInitializer;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistryListener;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;

public class BasicRoleModelRegistry implements IRoleModelRegistry {

	private Map<String, RoleModel> roleModelNameMap;
	private Set<IRoleModelRegistryListener> listeners;
	private IRoleModelRegistryInitializer initializer;

	public BasicRoleModelRegistry(){
		listeners = new HashSet<IRoleModelRegistryListener>();
	}

	@Override
	public void setInitializer(IRoleModelRegistryInitializer initializer) {
		this.initializer = initializer;
	}

	public Collection<RoleModel> getAllRegisteredRoleModels() {
		return getRoleModelNameMap().values();
	}

	public RoleModel getRoleModelByName(String name) {
		return getRoleModelNameMap().get(name);
	}

	public Map<String, RoleModel> getRoleModelNameMap() {
		if(roleModelNameMap == null){
			roleModelNameMap = new HashMap<String, RoleModel>();
			if(initializer != null){
				List<RoleModel> roleModels = initializer.initialize();
				registerInitializedRoleModels(roleModels);
			}
		}
		return roleModelNameMap;
	}

	private void registerInitializedRoleModels(List<RoleModel> roleModels) {
		for (RoleModel roleModel : roleModels) {
			try {
				registerRoleModel(roleModel);
			} catch (RoleModelAlreadyRegisteredException e) {
				Activator.getDefault().log(e.getMessage(), IStatus.ERROR);
			}
		}
	}

	public void registerRoleModel(RoleModel roleModel) throws RoleModelAlreadyRegisteredException {
		String name = roleModel.getName();
		RoleModel registeredModel = getRoleModelNameMap().get(name);
		if(registeredModel != null){
			throw new RoleModelAlreadyRegisteredException(roleModel);
		}
		getRoleModelNameMap().put(name, roleModel);
		for (IRoleModelRegistryListener listener : listeners) {
			listener.roleModelAdded(roleModel);
		}
	}

	public RoleModel unregisterRoleModel(RoleModel model) {
		RoleModel remove = getRoleModelNameMap().remove(model.getName());
		for (IRoleModelRegistryListener listener : listeners) {
			listener.roleModelRemoved(remove);
		}
		return remove;
	}

	@Override
	public void addRegistryListener(IRoleModelRegistryListener listener) {
		if(listener != null){
			listeners.add(listener);
		}
	}

	@Override
	public boolean removeRegistryListener(IRoleModelRegistryListener listener) {
		if(listener != null){
			return listeners.remove(listener);
		}
		return false;
	}
}
