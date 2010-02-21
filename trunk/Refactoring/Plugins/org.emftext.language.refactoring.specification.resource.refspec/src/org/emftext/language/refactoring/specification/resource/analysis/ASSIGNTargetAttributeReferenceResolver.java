/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.roles.RoleAttribute;

public class ASSIGNTargetAttributeReferenceResolver extends AbstractRoleAttributeResolver implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute> {
	
	private org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute> delegate = new org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute>();

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.analysis.AbstractRoleAttributeResolver#getSpecificRole(org.emftext.language.refactoring.refactoring_specification.ASSIGN)
	 */
	@Override
	protected RoleAttribute getSpecificRole(ASSIGN container) {
		return container.getTargetAttribute();
	}
	
}
