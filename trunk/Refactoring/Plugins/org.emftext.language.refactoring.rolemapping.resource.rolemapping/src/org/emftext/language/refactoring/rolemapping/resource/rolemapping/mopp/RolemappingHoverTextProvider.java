/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp;

public class RolemappingHoverTextProvider implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingHoverTextProvider {
	
	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui.RolemappingDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui.RolemappingDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
