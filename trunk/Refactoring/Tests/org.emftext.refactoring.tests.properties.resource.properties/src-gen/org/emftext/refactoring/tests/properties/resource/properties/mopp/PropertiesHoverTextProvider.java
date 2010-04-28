/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesHoverTextProvider implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesHoverTextProvider {
	
	private org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesDefaultHoverTextProvider defaultProvider = new org.emftext.refactoring.tests.properties.resource.properties.ui.PropertiesDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
