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

public interface IRoleMappingExtensionPoint {

	// general
	public static final String ID 						= "org.emftext.refactoring.rolemapping";
	public static final String RESOURCE_ATTRIBUTE 		= "rolemapping_resource";
	public static final String DEFAULT_ICON_ATTRIBUTE	= "defaultIcon";
	
	// icons
	public static final String SUB_MAPPING_ICON_ID		= "mappingIcon";
	public static final String SUB_MAPPING_NAME 		= "mapping_name";
	public static final String SUB_ICON_RESOURCE 		= "icon";
	
	// submenu
	public static final String SUB_MENU_ID 				= "submenu";
}
