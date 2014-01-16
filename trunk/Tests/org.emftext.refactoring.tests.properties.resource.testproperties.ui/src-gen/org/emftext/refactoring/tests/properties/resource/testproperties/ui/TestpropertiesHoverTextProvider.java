/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.ui;

import org.eclipse.emf.ecore.EObject;

public class TestpropertiesHoverTextProvider implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesHoverTextProvider {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesDefaultHoverTextProvider defaultProvider = new org.emftext.refactoring.tests.properties.resource.testproperties.ui.TestpropertiesDefaultHoverTextProvider();
	
	public String getHoverText(EObject container, EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
