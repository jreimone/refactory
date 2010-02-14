/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.roles.MultiplicityRelation;
import org.emftext.language.refactoring.roles.Relation;

public class RelationMappingRelationReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.RelationMapping, org.emftext.language.refactoring.roles.MultiplicityRelation> {
	
	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.RelationMapping, org.emftext.language.refactoring.roles.MultiplicityRelation> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.RelationMapping, org.emftext.language.refactoring.roles.MultiplicityRelation>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.RelationMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.emftext.language.refactoring.roles.MultiplicityRelation> result) {
		EObject parent = container.eContainer();
		if(!(parent instanceof Mapping)){
			result.setErrorMessage("Invalid RoleMapping Model");
			return;
		}
		Mapping mapping = (Mapping) parent;
		String[] names = identifier.split(",");
		if(names.length != 2){
			result.setErrorMessage("A mapped relation must be identified with source and target name, seperated by a comma");
			return;
		}
		String sourceName = names[0];
		String targetName = names[1];
		if(sourceName == null){
			sourceName = "";
		}
		if(targetName == null){
			targetName = "";
		}
		sourceName = sourceName.trim();
		targetName = targetName.trim();
		EList<MultiplicityRelation> relations = getMultiplicityRelations(mapping.getMappedRoleModel().getRelations());
		for (MultiplicityRelation relation : relations) {
			String relationSourceName = relation.getSourceName();
			String relationTargetName = relation.getTargetName();
			if(relationSourceName == null){
				relationSourceName = "";
			}
			if(relationTargetName == null){
				relationTargetName = "";
			}
			relationSourceName = relationSourceName.trim();
			relationTargetName = relationTargetName.trim();
			if(sourceName.equals(relationSourceName) && targetName.equals(relationTargetName)){
				result.addMapping(sourceName + "," + targetName, relation);
				return;
			}
		}
		result.setErrorMessage("No relation with source name '" + sourceName + "' and target name '" + targetName + "' could be found");
	}
	
	private static EList<MultiplicityRelation> getMultiplicityRelations(EList<Relation> relations){
		EList<MultiplicityRelation> multiplicityRelations = new BasicEList<MultiplicityRelation>();
		for (Relation relation : relations) {
			if(relation instanceof MultiplicityRelation){
				multiplicityRelations.add((MultiplicityRelation) relation);
			}
		}
		return multiplicityRelations;
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.MultiplicityRelation element, org.emftext.language.refactoring.rolemapping.RelationMapping container, org.eclipse.emf.ecore.EReference reference) {
		return element.getSourceName() + "," + element.getTargetName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
