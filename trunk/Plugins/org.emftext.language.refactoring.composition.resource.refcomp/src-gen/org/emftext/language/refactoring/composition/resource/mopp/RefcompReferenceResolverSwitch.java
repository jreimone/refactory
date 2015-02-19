/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class RefcompReferenceResolverSwitch implements org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected org.emftext.language.refactoring.composition.resource.analysis.CompositeRoleMappingTargetMetamodelReferenceResolver compositeRoleMappingTargetMetamodelReferenceResolver = new org.emftext.language.refactoring.composition.resource.analysis.CompositeRoleMappingTargetMetamodelReferenceResolver();
	protected org.emftext.language.refactoring.composition.resource.analysis.CompositeRoleMappingFirstReferenceResolver compositeRoleMappingFirstReferenceResolver = new org.emftext.language.refactoring.composition.resource.analysis.CompositeRoleMappingFirstReferenceResolver();
	protected org.emftext.language.refactoring.composition.resource.analysis.BoundRoleMappingRoleMappingReferenceResolver boundRoleMappingRoleMappingReferenceResolver = new org.emftext.language.refactoring.composition.resource.analysis.BoundRoleMappingRoleMappingReferenceResolver();
	protected org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingSourceRoleModelReferenceResolver sourceTargetBindingSourceRoleModelReferenceResolver = new org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingSourceRoleModelReferenceResolver();
	protected org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingSourceReferenceResolver sourceTargetBindingSourceReferenceResolver = new org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingSourceReferenceResolver();
	protected org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingTargetRoleModelReferenceResolver sourceTargetBindingTargetRoleModelReferenceResolver = new org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingTargetRoleModelReferenceResolver();
	protected org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingTargetReferenceResolver sourceTargetBindingTargetReferenceResolver = new org.emftext.language.refactoring.composition.resource.analysis.SourceTargetBindingTargetReferenceResolver();
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping, org.eclipse.emf.ecore.EPackage> getCompositeRoleMappingTargetMetamodelReferenceResolver() {
		return getResolverChain(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping_TargetMetamodel(), compositeRoleMappingTargetMetamodelReferenceResolver);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping, org.emftext.language.refactoring.rolemapping.RoleMapping> getCompositeRoleMappingFirstReferenceResolver() {
		return getResolverChain(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping_First(), compositeRoleMappingFirstReferenceResolver);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping, org.emftext.language.refactoring.rolemapping.RoleMapping> getBoundRoleMappingRoleMappingReferenceResolver() {
		return getResolverChain(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping_RoleMapping(), boundRoleMappingRoleMappingReferenceResolver);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.RoleModel> getSourceTargetBindingSourceRoleModelReferenceResolver() {
		return getResolverChain(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_SourceRoleModel(), sourceTargetBindingSourceRoleModelReferenceResolver);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.Role> getSourceTargetBindingSourceReferenceResolver() {
		return getResolverChain(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_Source(), sourceTargetBindingSourceReferenceResolver);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.RoleModel> getSourceTargetBindingTargetRoleModelReferenceResolver() {
		return getResolverChain(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_TargetRoleModel(), sourceTargetBindingTargetRoleModelReferenceResolver);
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding, org.emftext.language.refactoring.roles.Role> getSourceTargetBindingTargetReferenceResolver() {
		return getResolverChain(org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_Target(), sourceTargetBindingTargetReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		compositeRoleMappingTargetMetamodelReferenceResolver.setOptions(options);
		compositeRoleMappingFirstReferenceResolver.setOptions(options);
		boundRoleMappingRoleMappingReferenceResolver.setOptions(options);
		sourceTargetBindingSourceRoleModelReferenceResolver.setOptions(options);
		sourceTargetBindingSourceReferenceResolver.setOptions(options);
		sourceTargetBindingTargetRoleModelReferenceResolver.setOptions(options);
		sourceTargetBindingTargetReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping().isInstance(container)) {
			RefcompFuzzyResolveResult<org.eclipse.emf.ecore.EPackage> frr = new RefcompFuzzyResolveResult<org.eclipse.emf.ecore.EPackage>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("targetMetamodel")) {
				compositeRoleMappingTargetMetamodelReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping().isInstance(container)) {
			RefcompFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping> frr = new RefcompFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("first")) {
				compositeRoleMappingFirstReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping().isInstance(container)) {
			RefcompFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping> frr = new RefcompFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("roleMapping")) {
				boundRoleMappingRoleMappingReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().isInstance(container)) {
			RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel> frr = new RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("sourceRoleModel")) {
				sourceTargetBindingSourceRoleModelReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().isInstance(container)) {
			RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("source")) {
				sourceTargetBindingSourceReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().isInstance(container)) {
			RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel> frr = new RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.RoleModel>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("targetRoleModel")) {
				sourceTargetBindingTargetRoleModelReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding().isInstance(container)) {
			RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.Role> frr = new RefcompFuzzyResolveResult<org.emftext.language.refactoring.roles.Role>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("target")) {
				sourceTargetBindingTargetReferenceResolver.resolve(identifier, (org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping_TargetMetamodel()) {
			return getResolverChain(reference, compositeRoleMappingTargetMetamodelReferenceResolver);
		}
		if (reference == org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getCompositeRoleMapping_First()) {
			return getResolverChain(reference, compositeRoleMappingFirstReferenceResolver);
		}
		if (reference == org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getBoundRoleMapping_RoleMapping()) {
			return getResolverChain(reference, boundRoleMappingRoleMappingReferenceResolver);
		}
		if (reference == org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_SourceRoleModel()) {
			return getResolverChain(reference, sourceTargetBindingSourceRoleModelReferenceResolver);
		}
		if (reference == org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_Source()) {
			return getResolverChain(reference, sourceTargetBindingSourceReferenceResolver);
		}
		if (reference == org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_TargetRoleModel()) {
			return getResolverChain(reference, sourceTargetBindingTargetRoleModelReferenceResolver);
		}
		if (reference == org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage.eINSTANCE.getSourceTargetBinding_Target()) {
			return getResolverChain(reference, sourceTargetBindingTargetReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <ContainerType extends EObject, ReferenceType extends EObject> org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.language.refactoring.composition.resource.IRefcompOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new org.emftext.language.refactoring.composition.resource.util.RefcompRuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.language.refactoring.composition.resource.IRefcompOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver) {
			org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver replacingResolver = (org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.language.refactoring.composition.resource.IRefcompDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.language.refactoring.composition.resource.IRefcompDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.language.refactoring.composition.resource.IRefcompReferenceCache) {
					org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver nextResolver = (org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver) next;
					if (nextResolver instanceof org.emftext.language.refactoring.composition.resource.IRefcompDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.language.refactoring.composition.resource.IRefcompDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.language.refactoring.composition.resource.util.RefcompRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.refactoring.composition.resource.IRefcompOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.refactoring.composition.resource.IRefcompDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.language.refactoring.composition.resource.util.RefcompRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.refactoring.composition.resource.IRefcompOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.refactoring.composition.resource.IRefcompDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
