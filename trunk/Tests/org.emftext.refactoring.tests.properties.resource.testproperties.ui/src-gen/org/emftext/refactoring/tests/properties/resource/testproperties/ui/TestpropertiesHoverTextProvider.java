/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

public class TestpropertiesHoverTextProvider implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesHoverTextProvider {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesDefaultHoverTextProvider defaultProvider = new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
