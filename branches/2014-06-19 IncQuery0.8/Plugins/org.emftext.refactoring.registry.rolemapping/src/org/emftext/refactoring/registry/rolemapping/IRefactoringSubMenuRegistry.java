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
package org.emftext.refactoring.registry.rolemapping;

import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.impl.BasicRefactoringSubMenuRegistry;

public interface IRefactoringSubMenuRegistry {

	public static final IRefactoringSubMenuRegistry INSTANCE 	= new BasicRefactoringSubMenuRegistry();
	public static final String CONTEXT_MENU_ENTRY_ID 			= "org.emftext.refactoring.menu";
	
	/**
	 * Registers a new submenu with the given <code>id</code> and the <code>displayString</code>
	 * which will be shown in the 'Refactor' context menu. If set, <code>parentMenu</code>
	 * refers to a already registered refactoring submenu under which this submenu will be displayed.
	 * 
	 * @param id id of the submenu to be registered
	 * @param displayString the string which will be displayed in the 'Refactor' context menu
	 * @param parentMenu the id of the parent submenu; leave empty if only the 'Refactor' context menu should be the parent; if <code>parentMenu</code> is empty this menu will be registered as child of the 'Refactor' context menu, too 
	 */
	public void registerSubMenu(String id, String displayString, String parentMenu);
	
	/**
	 * Register a <code>rolemapping</code> to be displayed in the submenu identified with the
	 * given <code>submenuID</code>: 
	 * 
	 * @param rolemapping the rolemapping to be registered
	 * @param submenuID the ID of the submenu under which the rolemapping should be displayed; if <code>submenuID</code> is invalid the rolemapping will be displayed under the 'Refactor' context menu.
	 */
	public void registerRoleMappingForSubMenu(RoleMapping rolemapping, String submenuID);
	
	/**
	 * Returns the {@link IMenuManager submenu} to which the given <code>rolemapping</code> is registered.
	 * 
	 * @param rolemapping the rolemapping to get the {@link IMenuManager submenu} for
	 * @return the {@link IMenuManager submenu} to which the given <code>rolemapping</code> is registered
	 */
	public IMenuManager getSubMenuForRoleMapping(RoleMapping rolemapping);
	
	/**
	 * Returns an ordered list of the registered {@link IMenuManager submenu} from the given <code>rolemapping</code>
	 * to the root 'Refactor' context menu since a submenu can be a child of another submenu.
	 * The resulting list is ordered from the root 'Refactor' menu down to the leaf submenu from the registered
	 * <code>rolemapping</code>. 
	 * 
	 * @param rolemapping the rolemapping to get the submenu path from
	 * @return the submenu path from the root down to the submenu registered for the given <code>rolemapping</code>
	 */
	public List<IMenuManager> getSubMenuPathForRoleMapping(RoleMapping rolemapping);
}
