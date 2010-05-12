/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui;

import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextHoverTextProvider;

public class RolemappingHoverTextProvider implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingHoverTextProvider {
	
private org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui.RolemappingDefaultHoverTextProvider defaultProvider = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui.RolemappingDefaultHoverTextProvider();
	
	public java.lang.String getHoverText(org.eclipse.emf.ecore.EObject object) {
		if(object.eClass().getEPackage().equals(RolesPackage.eINSTANCE)){
			RolestextHoverTextProvider rolesHoverProvider = new RolestextHoverTextProvider();
			return rolesHoverProvider.getHoverText(object);
		}
		return defaultProvider.getHoverText(object);
	}
	
}
