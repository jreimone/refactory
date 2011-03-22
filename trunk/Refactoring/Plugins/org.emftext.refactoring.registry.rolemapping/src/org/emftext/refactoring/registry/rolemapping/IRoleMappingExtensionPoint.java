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
