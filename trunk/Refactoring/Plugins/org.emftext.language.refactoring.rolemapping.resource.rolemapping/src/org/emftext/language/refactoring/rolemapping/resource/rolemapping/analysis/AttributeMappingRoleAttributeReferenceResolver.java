/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;

public class AttributeMappingRoleAttributeReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.AttributeMapping, org.emftext.language.refactoring.roles.RoleAttribute> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.AttributeMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.emftext.language.refactoring.roles.RoleAttribute> result) {
		EObject parent = container.eContainer();
		if(!(parent instanceof ConcreteMapping)){
			result.setErrorMessage("Invalid RoleMapping Model");
			return;
		}
		ConcreteMapping mapping = (ConcreteMapping) parent;
		Role role = mapping.getRole();
		EList<RoleAttribute> attributes = role.getAttributes();
		for (RoleAttribute attribute : attributes) {
			if(attribute.getName().equals(identifier)){
				result.addMapping(identifier, attribute);
				return;
			}
		}
		result.setErrorMessage("Role '" + role.getName() + "' has no attribute called '" + identifier + "'");
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.RoleAttribute element, org.emftext.language.refactoring.rolemapping.AttributeMapping container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
