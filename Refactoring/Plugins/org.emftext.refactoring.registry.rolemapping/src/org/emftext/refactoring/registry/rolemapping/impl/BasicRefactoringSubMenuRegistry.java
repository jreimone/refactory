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
package org.emftext.refactoring.registry.rolemapping.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRefactoringSubMenuRegistry;
import org.emftext.refactoring.registry.rolemapping.ISubMenuExtensionPoint;
import org.emftext.refactoring.util.RegistryUtil;

public class BasicRefactoringSubMenuRegistry implements IRefactoringSubMenuRegistry {

	private Map<String, SubMenuNode> menuIDMap;
	private Map<RoleMapping, SubMenuNode> rolemappingMenuMap;
	private SubMenuNode root;
	
	public BasicRefactoringSubMenuRegistry(){
		initializeSubMenuTree();
	}
	
	private void initializeSubMenuTree() {
		root = new SubMenuNode(null, null);
		menuIDMap = new LinkedHashMap<String, SubMenuNode>();
		rolemappingMenuMap = new LinkedHashMap<RoleMapping, SubMenuNode>();
		IConfigurationElement[] configurationElements = RegistryUtil.collectConfigurationElements(ISubMenuExtensionPoint.ID);
		for (IConfigurationElement element : configurationElements) {
			String submenuID = element.getAttribute(ISubMenuExtensionPoint.SUBMENU_ID_ATTRIBUTE);
			String parent = element.getAttribute(ISubMenuExtensionPoint.GENERALISES_ATTRIBUTE);
			String displayString = element.getAttribute(ISubMenuExtensionPoint.DISPLAY_STRING_ATTRIBUTE);
			register(submenuID, parent, displayString); 
		}
	}

	private void register(String submenuID, String parent, String displayString) {
		SubMenuNode submenuNode = menuIDMap.get(submenuID);
		SubMenuNode parentNode = null;
		if(parent != null){
			parentNode = menuIDMap.get(parent);
		}
		if(parentNode == null){
			parentNode = root;
		}
		if(submenuNode == null){
			IMenuManager submenu = new MenuManager(displayString, CONTEXT_MENU_ENTRY_ID + "." + submenuID);
			submenuNode = new SubMenuNode(parentNode, submenu);
			menuIDMap.put(submenuID, submenuNode);
		}
	}

	public void registerSubMenu(String id, String displayString, String parentMenu) {
		register(id, parentMenu, displayString);
	}

	public void registerRoleMappingForSubMenu(RoleMapping rolemapping, String submenuID) {
		SubMenuNode subMenuNode = menuIDMap.get(submenuID);
		SubMenuNode registeredNode = rolemappingMenuMap.get(rolemapping);
		if(registeredNode == null){
			rolemappingMenuMap.put(rolemapping, subMenuNode);
		}
	}

	public IMenuManager getSubMenuForRoleMapping(RoleMapping rolemapping) {
		SubMenuNode subMenuNode = rolemappingMenuMap.get(rolemapping);
		if(subMenuNode != null){
			return subMenuNode.getMenu();
		}
		return null;
	}

	public List<IMenuManager> getSubMenuPathForRoleMapping(RoleMapping rolemapping) {
		List<IMenuManager> submenus = new LinkedList<IMenuManager>();
		SubMenuNode subMenuNode = rolemappingMenuMap.get(rolemapping);
		if(subMenuNode != null){
			submenus.add(subMenuNode.getMenu());
			subMenuNode = subMenuNode.getParent();
			while (subMenuNode.getParent() != null) {
				submenus.add(subMenuNode.getMenu());
				subMenuNode = subMenuNode.getParent();
			}
		}
		Collections.reverse(submenus);
		return submenus;
	}

}
