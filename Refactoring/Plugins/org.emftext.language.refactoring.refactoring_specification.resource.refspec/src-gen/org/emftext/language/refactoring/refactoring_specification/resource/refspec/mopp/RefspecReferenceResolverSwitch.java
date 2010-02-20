/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecReferenceResolverSwitch implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolverSwitch {
	
	protected org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RefactoringSpecificationUsedRoleModelReferenceResolver refactoringSpecificationUsedRoleModelReferenceResolver = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RefactoringSpecificationUsedRoleModelReferenceResolver();
	protected org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.VariableReferenceVariableReferenceResolver variableReferenceVariableReferenceResolver = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.VariableReferenceVariableReferenceResolver();
	protected org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RoleReferenceRoleReferenceResolver roleReferenceRoleReferenceResolver = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RoleReferenceRoleReferenceResolver();
	protected org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RelationReferenceRelationReferenceResolver relationReferenceRelationReferenceResolver = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RelationReferenceRelationReferenceResolver();
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RefactoringSpecificationUsedRoleModelReferenceResolver getRefactoringSpecificationUsedRoleModelReferenceResolver() {
		return refactoringSpecificationUsedRoleModelReferenceResolver;
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.VariableReferenceVariableReferenceResolver getVariableReferenceVariableReferenceResolver() {
		return variableReferenceVariableReferenceResolver;
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RoleReferenceRoleReferenceResolver getRoleReferenceRoleReferenceResolver() {
		return roleReferenceRoleReferenceResolver;
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RelationReferenceRelationReferenceResolver getRelationReferenceRelationReferenceResolver() {
		return relationReferenceRelationReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		refactoringSpecificationUsedRoleModelReferenceResolver.setOptions(options);
		variableReferenceVariableReferenceResolver.setOptions(options);
		roleReferenceRoleReferenceResolver.setOptions(options);
		relationReferenceRelationReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				refactoringSpecificationUsedRoleModelReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.refactoring_specification.Variable> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.refactoring_specification.Variable>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				variableReferenceVariableReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.VariableReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRoleReference().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				roleReferenceRoleReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.RoleReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Relation> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Relation>(result);
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(reference.getName());
			if (feature instanceof org.eclipse.emf.ecore.EReference) {
				relationReferenceRelationReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.RelationReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
}
