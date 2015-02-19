/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.ui;

import org.eclipse.emf.ecore.EObject;

public class RefcompHoverTextProvider implements org.emftext.language.refactoring.composition.resource.IRefcompHoverTextProvider {
	
	private org.emftext.language.refactoring.composition.resource.ui.RefcompDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.composition.resource.ui.RefcompDefaultHoverTextProvider();
	
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
