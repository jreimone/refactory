/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingHoverTextProvider;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextHoverTextProvider;

public class RolemappingHoverTextProvider implements IRolemappingHoverTextProvider {
	
	private RolemappingDefaultHoverTextProvider defaultProvider = new RolemappingDefaultHoverTextProvider();

	public String getHoverText(EObject container, EObject referencedObject) {
		return getHoverText(referencedObject);
	}
	
	public String getHoverText(EObject object) {
		if (object.eClass().getEPackage().equals(RolesPackage.eINSTANCE)) {
			RolestextHoverTextProvider rolesHoverProvider = new RolestextHoverTextProvider();
			return rolesHoverProvider.getHoverText(object);
		}
		return defaultProvider.getHoverText(object);
	}
	
}
