package org.emftext.refactoring.registry.rolemapping;

public interface ICustomWizardPageExtensionPoint {
	
	public static final String ID 						= "org.emftext.refactoring.customwizardpage";
	public static final String ATTRIBUTE_NS_URI 		= "nsUri";
	public static final String ATTRIBUTE_MAPPING 		= "mapping_name";
	public static final String ATTRIBUTE_WIZARD_PAGE 	= "wizard_page_class_name";
}
