/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.ui;

public class PropertiesUIMetaInformation extends org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesMetaInformation {
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesHoverTextProvider getHoverTextProvider() {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesHoverTextProvider();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesImageProvider getImageProvider() {
		return org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesImageProvider.INSTANCE;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager createColorManager() {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.refactoring.tests.properties.resource.properties.
	 * IPropertiesTextResource,
	 * org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorM
	 * anager) instead.
	 */
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner createTokenScanner(org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner createTokenScanner(org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextResource resource, org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesColorManager colorManager) {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesTokenScanner(resource, colorManager);
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesCodeCompletionHelper();
	}
	
}
