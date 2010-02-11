/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextReferenceResolverSwitch implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolverSwitch {
	
	protected org.emftext.language.refactoring.roles.resource.rolestext.analysis.RelationSourceReferenceResolver relationSourceReferenceResolver = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RelationSourceReferenceResolver();
	protected org.emftext.language.refactoring.roles.resource.rolestext.analysis.RelationTargetReferenceResolver relationTargetReferenceResolver = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RelationTargetReferenceResolver();
	
	public org.emftext.language.refactoring.roles.resource.rolestext.analysis.RelationSourceReferenceResolver getRelationSourceReferenceResolver() {
		return relationSourceReferenceResolver;
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.analysis.RelationTargetReferenceResolver getRelationTargetReferenceResolver() {
		return relationTargetReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		relationSourceReferenceResolver.setOptions(options);
		relationTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRelation().isInstance(container)) {
			RolestextFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RolestextFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				relationSourceReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.roles.Relation) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.roles.RolesPackage.eINSTANCE.getRelation().isInstance(container)) {
			RolestextFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RolestextFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				relationTargetReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.roles.Relation) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
}
