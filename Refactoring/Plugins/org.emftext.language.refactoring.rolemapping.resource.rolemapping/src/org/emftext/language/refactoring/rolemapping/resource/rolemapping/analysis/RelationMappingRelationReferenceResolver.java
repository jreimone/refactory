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
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.Role;

public class RelationMappingRelationReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.RelationMapping, org.emftext.language.refactoring.roles.MultiplicityRelation> {

	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.RelationMapping, org.emftext.language.refactoring.roles.MultiplicityRelation> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.RelationMapping, org.emftext.language.refactoring.roles.MultiplicityRelation>();

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.RelationMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.emftext.language.refactoring.roles.MultiplicityRelation> result) {
		EObject parent = container.eContainer();
		if(!(parent instanceof ConcreteMapping)){
			result.setErrorMessage("Invalid RoleMapping Model");
			return;
		}
		ConcreteMapping concreteMapping = (ConcreteMapping) parent;
		String targetName = identifier;
		if(targetName == null){
			targetName = "";
		}
		targetName = targetName.trim();
		Role mappedRole = concreteMapping.getRole();
		EList<Relation> outgoingRelations = mappedRole.getOutgoing();
		for (Relation relation : outgoingRelations) {
			if(relation instanceof MultiplicityRelation){
				String relationTargetName = ((MultiplicityRelation) relation).getTargetName();
				if(relationTargetName == null){
					relationTargetName = "";
				}
				relationTargetName = relationTargetName.trim();
				if(targetName.equals(relationTargetName)){
					result.addMapping(targetName, (MultiplicityRelation) relation);
					return;
				}
			}
		}
		result.setErrorMessage("Role '" + mappedRole.getName() + "' has no outgoing relation with target name '" + targetName + "'");
	}

	public java.lang.String deResolve(org.emftext.language.refactoring.roles.MultiplicityRelation element, org.emftext.language.refactoring.rolemapping.RelationMapping container, org.eclipse.emf.ecore.EReference reference) {
		return element.getTargetName();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
