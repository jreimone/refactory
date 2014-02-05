/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.ui;

import org.eclipse.emf.ecore.EObject;

public class OperatorsHoverTextProvider implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsHoverTextProvider {
	
	private org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsDefaultHoverTextProvider defaultProvider = new org.modelrefactoring.evolution.operators.resource.operators.ui.OperatorsDefaultHoverTextProvider();
	
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
