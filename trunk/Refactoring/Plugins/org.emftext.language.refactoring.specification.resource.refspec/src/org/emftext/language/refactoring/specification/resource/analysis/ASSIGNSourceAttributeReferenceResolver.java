/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;

public class ASSIGNSourceAttributeReferenceResolver extends AbstractRoleFeatureResolver<ASSIGN, RoleAttribute> implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute> {
	
	private org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute> delegate = new org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute>();
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}


	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.analysis.AbstractRoleFeatureResolver#getStructuralFeature(org.emftext.language.refactoring.roles.Role)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature(Role role) {
		return role.eClass().getEStructuralFeature("attributes");
	}


	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver#deResolve(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference)
	 */
	public String deResolve(RoleAttribute element, ASSIGN container, EReference reference) {
		return element.getAttributeRole().getName() + "." + element.getName();
	}
	
}
