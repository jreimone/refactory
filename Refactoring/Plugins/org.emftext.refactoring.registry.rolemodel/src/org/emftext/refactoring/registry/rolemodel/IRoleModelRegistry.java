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
package org.emftext.refactoring.registry.rolemodel;

import java.util.Collection;
import java.util.Set;

import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;
import org.emftext.refactoring.registry.rolemodel.impl.BasicRoleModelRegistry;

/**
 * Interface for {@link RoleModel} registries.
 * 
 * @author jreimann
 *
 */
public interface IRoleModelRegistry {

	public static IRoleModelRegistry INSTANCE = new BasicRoleModelRegistry();
	
	
//	/**
//	 * Returns the map containing the namespace URI of a {@link RoleModel} as key and the {@link RoleModel} itself as value.
//	 * 
//	 * @return
//	 */
//	public Map<String, RoleModel> getRoleModelUriMap();
	
	/**
	 * Returns a list of all registered {@link RoleModel}s.
	 * 
	 * @return
	 */
	public Collection<RoleModel> getAllRegisteredRoleModels();
	
	/**
	 * This method can be used to register {@link RoleModel}s at runtime. Maybe if it is currently being developed
	 * and the modeler already wants to run refactorings against this {@link RoleModel}. 
	 * 
	 * @param roleModel the {@link RoleModel} to be registered
	 * @throws RoleModelAlreadyRegisteredException if a {@link RoleModel} with the same name or namespace Uri already exists in the registry
	 */
	public void registerRoleModel(RoleModel roleModel) throws RoleModelAlreadyRegisteredException;
	
	/**
	 * Returns a {@link RoleModel} by its name.
	 * 
	 * @param name of the desired {@link RoleModel}
	 * @return the desired {@link RoleModel}
	 */
	public RoleModel getRoleModelByName(String name);
	
	/**
	 * Use this method to unregister an already registered role model.
	 * @param model
	 * @return the unregistered roleModel or <code>null</code> if there was no roleModel registered
	 */
	public RoleModel unregisterRoleModel(RoleModel roleModel);
	
	/**
	 * Adds a listener to this registry which is notified when the registry changes.
	 * @param listener
	 */
	public void addRegistryListener(IRoleModelRegistryListener listener);
	
	/**
	 * The given listener is removed and will not be notified anymore.
	 * @param listener
	 * @return see {@link Set#remove(Object)}
	 */
	public boolean removeRegistryListener(IRoleModelRegistryListener listener);
}
