/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextHoverTextProvider;

public class RefspecHoverTextProvider implements org.emftext.language.refactoring.specification.resource.IRefspecHoverTextProvider {
	
	private org.emftext.language.refactoring.specification.resource.ui.RefspecDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.specification.resource.ui.RefspecDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		if(object.eClass().getEPackage().equals(RolesPackage.eINSTANCE)){
			RolestextHoverTextProvider rolesHoverProvider = new RolestextHoverTextProvider();
			return rolesHoverProvider.getHoverText(object);
		}
		return defaultProvider.getHoverText(object);
	}
	
}
