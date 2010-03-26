/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RelationMapping;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.Role;

public class RelationMappingRelationReferenceResolver implements IRolemappingReferenceResolver<RelationMapping, MultiplicityRelation> {

	public void resolve(String identifier, RelationMapping container, EReference reference, int position, boolean resolveFuzzy, IRolemappingReferenceResolveResult<MultiplicityRelation> result) {
		EObject parent = container.eContainer();
		if (!(parent instanceof ConcreteMapping)) {
			result.setErrorMessage("Invalid RoleMapping Model");
			return;
		}
		ConcreteMapping concreteMapping = (ConcreteMapping) parent;
		String targetName = identifier;
		if (targetName == null) {
			targetName = "";
		}
		targetName = targetName.trim();
		Role mappedRole = concreteMapping.getRole();
		EList<Relation> outgoingRelations = mappedRole.getOutgoing();
		for (Relation relation : outgoingRelations) {
			if (relation instanceof MultiplicityRelation) {
				String relationTargetName = ((MultiplicityRelation) relation).getTargetName();
				if (relationTargetName == null) {
					relationTargetName = "";
				}
				relationTargetName = relationTargetName.trim();
				if (targetName.equals(relationTargetName) || resolveFuzzy) {
					result.addMapping(relationTargetName, (MultiplicityRelation) relation);
					if (!resolveFuzzy) {
						return;
					}
				}
			}
		}
		result.setErrorMessage("Role '" + mappedRole.getName() + "' has no outgoing relation with target name '" + targetName + "'");
	}

	public String deResolve(MultiplicityRelation element, RelationMapping container, EReference reference) {
		return element.getTargetName();
	}

	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
}
