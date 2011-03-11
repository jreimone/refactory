/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.ui;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextHoverTextProvider;
import org.emftext.language.refactoring.specification.resource.IRefspecHoverTextProvider;

public class RefspecHoverTextProvider implements IRefspecHoverTextProvider {
	
	private RefspecDefaultHoverTextProvider defaultProvider = new RefspecDefaultHoverTextProvider();
	
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
