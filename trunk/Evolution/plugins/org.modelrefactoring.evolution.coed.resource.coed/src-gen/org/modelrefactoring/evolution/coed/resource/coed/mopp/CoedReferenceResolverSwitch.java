/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class CoedReferenceResolverSwitch implements org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected org.modelrefactoring.evolution.coed.resource.coed.analysis.CoEvolutionDefinitionMetamodelReferenceResolver coEvolutionDefinitionMetamodelReferenceResolver = new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoEvolutionDefinitionMetamodelReferenceResolver();
	protected org.modelrefactoring.evolution.coed.resource.coed.analysis.RoleMappingEventConcreteRefactoringReferenceResolver roleMappingEventConcreteRefactoringReferenceResolver = new org.modelrefactoring.evolution.coed.resource.coed.analysis.RoleMappingEventConcreteRefactoringReferenceResolver();
	protected org.modelrefactoring.evolution.coed.resource.coed.analysis.RoleMappingActionConcreteRefactoringReferenceResolver roleMappingActionConcreteRefactoringReferenceResolver = new org.modelrefactoring.evolution.coed.resource.coed.analysis.RoleMappingActionConcreteRefactoringReferenceResolver();
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<org.modelrefactoring.evolution.coed.CoEvolutionDefinition, org.eclipse.emf.ecore.EPackage> getCoEvolutionDefinitionMetamodelReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition_Metamodel(), coEvolutionDefinitionMetamodelReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<org.modelrefactoring.evolution.coed.RoleMappingEvent, org.emftext.language.refactoring.rolemapping.RoleMapping> getRoleMappingEventConcreteRefactoringReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent_ConcreteRefactoring(), roleMappingEventConcreteRefactoringReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<org.modelrefactoring.evolution.coed.RoleMappingAction, org.emftext.language.refactoring.rolemapping.RoleMapping> getRoleMappingActionConcreteRefactoringReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction_ConcreteRefactoring(), roleMappingActionConcreteRefactoringReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		coEvolutionDefinitionMetamodelReferenceResolver.setOptions(options);
		roleMappingEventConcreteRefactoringReferenceResolver.setOptions(options);
		roleMappingActionConcreteRefactoringReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition().isInstance(container)) {
			CoedFuzzyResolveResult<org.eclipse.emf.ecore.EPackage> frr = new CoedFuzzyResolveResult<org.eclipse.emf.ecore.EPackage>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("metamodel")) {
				coEvolutionDefinitionMetamodelReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.coed.CoEvolutionDefinition) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent().isInstance(container)) {
			CoedFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping> frr = new CoedFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("concreteRefactoring")) {
				roleMappingEventConcreteRefactoringReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.coed.RoleMappingEvent) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction().isInstance(container)) {
			CoedFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping> frr = new CoedFuzzyResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("concreteRefactoring")) {
				roleMappingActionConcreteRefactoringReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.coed.RoleMappingAction) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getCoEvolutionDefinition_Metamodel()) {
			return getResolverChain(reference, coEvolutionDefinitionMetamodelReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingEvent_ConcreteRefactoring()) {
			return getResolverChain(reference, roleMappingEventConcreteRefactoringReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.coed.CoedPackage.eINSTANCE.getRoleMappingAction_ConcreteRefactoring()) {
			return getResolverChain(reference, roleMappingActionConcreteRefactoringReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <ContainerType extends EObject, ReferenceType extends EObject> org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new org.modelrefactoring.evolution.coed.resource.coed.util.CoedRuntimeUtil().logWarning("Found value with invalid type for option " + org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver) {
			org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver replacingResolver = (org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.modelrefactoring.evolution.coed.resource.coed.ICoedDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.modelrefactoring.evolution.coed.resource.coed.ICoedDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceCache) {
					org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver nextResolver = (org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver) next;
					if (nextResolver instanceof org.modelrefactoring.evolution.coed.resource.coed.ICoedDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.modelrefactoring.evolution.coed.resource.coed.ICoedDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.modelrefactoring.evolution.coed.resource.coed.util.CoedRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.modelrefactoring.evolution.coed.resource.coed.ICoedDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.modelrefactoring.evolution.coed.resource.coed.util.CoedRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.modelrefactoring.evolution.coed.resource.coed.ICoedDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
