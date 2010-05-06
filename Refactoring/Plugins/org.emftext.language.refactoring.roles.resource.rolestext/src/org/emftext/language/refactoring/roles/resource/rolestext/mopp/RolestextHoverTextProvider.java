/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextHoverTextProvider implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextHoverTextProvider {
	
	private org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
