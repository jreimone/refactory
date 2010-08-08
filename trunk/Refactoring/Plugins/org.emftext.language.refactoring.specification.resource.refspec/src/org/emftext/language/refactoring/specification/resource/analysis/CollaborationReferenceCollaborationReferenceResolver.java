/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;

public class CollaborationReferenceCollaborationReferenceResolver extends AbstractRoleFeatureResolver<CollaborationReference, MultiplicityCollaboration>  implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.CollaborationReference, org.emftext.language.refactoring.roles.MultiplicityCollaboration> {
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.MultiplicityCollaboration element, org.emftext.language.refactoring.refactoring_specification.CollaborationReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getSource().getName() + "." + element.getTargetName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.specification.resource.analysis.AbstractRoleFeatureResolver#getStructuralFeature(org.emftext.language.refactoring.roles.Role)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature(Role role) {
		return role.eClass().getEStructuralFeature("outgoing");
	}	
}
