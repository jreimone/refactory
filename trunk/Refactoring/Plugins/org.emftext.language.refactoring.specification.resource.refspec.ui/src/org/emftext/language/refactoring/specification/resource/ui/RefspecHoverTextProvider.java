/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.ui;

public class RefspecHoverTextProvider implements org.emftext.language.refactoring.specification.resource.IRefspecHoverTextProvider {
	
	private org.emftext.language.refactoring.specification.resource.ui.RefspecDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.specification.resource.ui.RefspecDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
