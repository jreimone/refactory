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

import org.emftext.language.refactoring.roles.RoleModel;

/**
 * Implement this interface to get informed if the {@link IRoleModelRegistry} has changed.
 * 
 * @author jreimann
 *
 */
public interface IRoleModelRegistryListener {

	/**
	 * Is fired when a role model was removed from the registry.
	 * 
	 * @param roleModel which was removed
	 */
	public void roleModelRemoved(RoleModel roleModel);
	
	/**
	 * Is fired when a role model was added to the registry.
	 * 
	 * @param roleModel which was added
	 */
	public void roleModelAdded(RoleModel roleModel);
}
