/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecReferenceResolverSwitch implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolverSwitch {
	
	protected org.emftext.language.refactoring.specification.resource.analysis.RefactoringSpecificationUsedRoleModelReferenceResolver refactoringSpecificationUsedRoleModelReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.RefactoringSpecificationUsedRoleModelReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.CREATESourceRoleReferenceResolver cREATESourceRoleReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.CREATESourceRoleReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.ContainmentCommandIndexReferenceResolver containmentCommandIndexReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.ContainmentCommandIndexReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.ASSIGNSourceAttributeReferenceResolver aSSIGNSourceAttributeReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.ASSIGNSourceAttributeReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.ASSIGNTargetAttributeReferenceResolver aSSIGNTargetAttributeReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.ASSIGNTargetAttributeReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.VariableReferenceVariableReferenceResolver variableReferenceVariableReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.VariableReferenceVariableReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.RoleReferenceRoleReferenceResolver roleReferenceRoleReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.RoleReferenceRoleReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.TRACERoleReferenceResolver tRACERoleReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.TRACERoleReferenceResolver();
	protected org.emftext.language.refactoring.specification.resource.analysis.RelationReferenceRelationReferenceResolver relationReferenceRelationReferenceResolver = new org.emftext.language.refactoring.specification.resource.analysis.RelationReferenceRelationReferenceResolver();
	
	public org.emftext.language.refactoring.specification.resource.analysis.RefactoringSpecificationUsedRoleModelReferenceResolver getRefactoringSpecificationUsedRoleModelReferenceResolver() {
		return refactoringSpecificationUsedRoleModelReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.CREATESourceRoleReferenceResolver getCREATESourceRoleReferenceResolver() {
		return cREATESourceRoleReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.ContainmentCommandIndexReferenceResolver getContainmentCommandIndexReferenceResolver() {
		return containmentCommandIndexReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.ASSIGNSourceAttributeReferenceResolver getASSIGNSourceAttributeReferenceResolver() {
		return aSSIGNSourceAttributeReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.ASSIGNTargetAttributeReferenceResolver getASSIGNTargetAttributeReferenceResolver() {
		return aSSIGNTargetAttributeReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.VariableReferenceVariableReferenceResolver getVariableReferenceVariableReferenceResolver() {
		return variableReferenceVariableReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.RoleReferenceRoleReferenceResolver getRoleReferenceRoleReferenceResolver() {
		return roleReferenceRoleReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.TRACERoleReferenceResolver getTRACERoleReferenceResolver() {
		return tRACERoleReferenceResolver;
	}
	
	public org.emftext.language.refactoring.specification.resource.analysis.RelationReferenceRelationReferenceResolver getRelationReferenceRelationReferenceResolver() {
		return relationReferenceRelationReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		refactoringSpecificationUsedRoleModelReferenceResolver.setOptions(options);
		cREATESourceRoleReferenceResolver.setOptions(options);
		containmentCommandIndexReferenceResolver.setOptions(options);
		aSSIGNSourceAttributeReferenceResolver.setOptions(options);
		aSSIGNTargetAttributeReferenceResolver.setOptions(options);
		variableReferenceVariableReferenceResolver.setOptions(options);
		roleReferenceRoleReferenceResolver.setOptions(options);
		tRACERoleReferenceResolver.setOptions(options);
		relationReferenceRelationReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(java.lang.String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("usedRoleModel")) {
				refactoringSpecificationUsedRoleModelReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("sourceRole")) {
				cREATESourceRoleReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.CREATE) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getContainmentCommand().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.refactoring_specification.IndexVariable> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.refactoring_specification.IndexVariable>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("index")) {
				containmentCommandIndexReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.ContainmentCommand) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getASSIGN().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleAttribute> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleAttribute>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("sourceAttribute")) {
				aSSIGNSourceAttributeReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.ASSIGN) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getASSIGN().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleAttribute> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleAttribute>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("targetAttribute")) {
				aSSIGNTargetAttributeReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.ASSIGN) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.refactoring_specification.Variable> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.refactoring_specification.Variable>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("variable")) {
				variableReferenceVariableReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.VariableReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRoleReference().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("role")) {
				roleReferenceRoleReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.RoleReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getTRACE().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("role")) {
				tRACERoleReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.TRACE) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference().isInstance(container)) {
			RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.MultiplicityRelation> frr = new RefspecFuzzyResolveResult<org.emftext.language.refactoring.roles.MultiplicityRelation>(result);
			java.lang.String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("relation")) {
				relationReferenceRelationReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoring_specification.RelationReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRefactoringSpecification_UsedRoleModel()) {
			return refactoringSpecificationUsedRoleModelReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getCREATE_SourceRole()) {
			return cREATESourceRoleReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getContainmentCommand_Index()) {
			return containmentCommandIndexReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getASSIGN_SourceAttribute()) {
			return aSSIGNSourceAttributeReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getASSIGN_TargetAttribute()) {
			return aSSIGNTargetAttributeReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getVariableReference_Variable()) {
			return variableReferenceVariableReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRoleReference_Role()) {
			return roleReferenceRoleReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getTRACE_Role()) {
			return tRACERoleReferenceResolver;
		}
		if (reference == org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage.eINSTANCE.getRelationReference_Relation()) {
			return relationReferenceRelationReferenceResolver;
		}
		return null;
	}
	
}
