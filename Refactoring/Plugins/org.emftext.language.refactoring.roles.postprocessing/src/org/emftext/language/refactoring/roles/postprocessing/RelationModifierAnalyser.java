/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.emftext.language.refactoring.roles.Relation;
import org.emftext.language.refactoring.roles.RelationModifier;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;
import org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextEObjectUtil;

/**
 * Analyses the modifiers of relations and checks that every modifier occurs only once.
 * 
 * @author Jan Reimann
 *
 */
public class RelationModifierAnalyser extends AbstractPostProcessor {

	private static final String UNIQUE_RELATION_MODIFIER = "The modifier \"%1$s\" of %2$s between %3$s (source) and %4$s (target) mustn't be set repeatedly.";
	
	private Set<RelationModifier> uniqueModifier;
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.roles.postprocessing.AbstractPostProcessor#analyse(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource, org.emftext.language.refactoring.roles.RoleModel)
	 */
	@Override
	public void analyse(RolestextResource resource, RoleModel model) {
		Collection<Relation> relations = RolestextEObjectUtil.getObjectsByType(model.eAllContents(), RolesPackage.eINSTANCE.getRelation());
		for (Relation relation : relations) {
			uniqueModifier = new HashSet<RelationModifier>();
			List<RelationModifier> modifier = relation.getModifier();
			for (RelationModifier relationModifier : modifier) {
				boolean unique = uniqueModifier.add(relationModifier);
				if(!unique){
					addProblem(resource
							, ERoleModelProblemType.RELATION_MODIFIER_ALREADY_SET
							, String.format(UNIQUE_RELATION_MODIFIER, relationModifier.getName(), relation.eClass().getName(), relation.getSource().getName(), relation.getTarget().getName())
							, relation);
				}
			}
		}
	}

}
