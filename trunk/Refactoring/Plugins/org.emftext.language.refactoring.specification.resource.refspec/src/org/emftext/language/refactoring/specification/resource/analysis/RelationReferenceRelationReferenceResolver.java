/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.refactoring.refactoring_specification.RelationReference;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Role;

public class RelationReferenceRelationReferenceResolver extends AbstractRoleFeatureResolver<RelationReference, MultiplicityRelation> implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.RelationReference, org.emftext.language.refactoring.roles.MultiplicityRelation> {
	
	private org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.RelationReference, org.emftext.language.refactoring.roles.MultiplicityRelation> delegate = new org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.RelationReference, org.emftext.language.refactoring.roles.MultiplicityRelation>();
	
//	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.refactoring_specification.RelationReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<org.emftext.language.refactoring.roles.MultiplicityRelation> result) {
//		if(container.getRelationRole() == null || container.getRelationRole().getRole() == null){
//			result.setErrorMessage("Could not resolve relation '" + identifier + "' because an invalid role was specified");
//			return;
//		}
//		Role role = container.getRelationRole().getRole();
//		EList<Relation> relations = role.getOutgoing();
//		for (Relation relation : relations) {
//			if(relation instanceof MultiplicityRelation){
//				if(((MultiplicityRelation) relation).getTargetName().equals(identifier)){
//					result.addMapping(identifier, (MultiplicityRelation) relation);
//					return;
//				}
//			}
//		}
//		result.setErrorMessage("Role '" + role.getName() + "' has no outgoing relation '" + identifier + "'");
//	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.MultiplicityRelation element, org.emftext.language.refactoring.refactoring_specification.RelationReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getTargetName();
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
