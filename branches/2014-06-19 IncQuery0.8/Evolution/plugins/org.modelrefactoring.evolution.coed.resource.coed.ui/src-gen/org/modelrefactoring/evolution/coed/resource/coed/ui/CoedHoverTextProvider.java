/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.ui;

import org.eclipse.emf.ecore.EObject;

public class CoedHoverTextProvider implements org.modelrefactoring.evolution.coed.resource.coed.ICoedHoverTextProvider {
	
	private org.modelrefactoring.evolution.coed.resource.coed.ui.CoedDefaultHoverTextProvider defaultProvider = new org.modelrefactoring.evolution.coed.resource.coed.ui.CoedDefaultHoverTextProvider();
	
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
