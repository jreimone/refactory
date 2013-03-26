/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

public class TestpropertiesUIMetaInformation extends org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesMetaInformation {
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesHoverTextProvider getHoverTextProvider() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesHoverTextProvider();
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesImageProvider getImageProvider() {
		return org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesImageProvider.INSTANCE;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesColorManager createColorManager() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.refactoring.tests.properties.resource.testpropert
	 * ies.ITestpropertiesTextResource,
	 * org.emftext.refactoring.tests.properties.resource.testproperties.ui.Testproperti
	 * esColorManager) instead.
	 */
	public org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesTokenScanner createTokenScanner(org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesColorManager colorManager) {
		return (org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesTokenScanner) createTokenScanner(null, colorManager);
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ui.ITestpropertiesTokenScanner createTokenScanner(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource resource, org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesColorManager colorManager) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesTokenScanner(resource, colorManager);
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesCodeCompletionHelper();
	}
	
}
