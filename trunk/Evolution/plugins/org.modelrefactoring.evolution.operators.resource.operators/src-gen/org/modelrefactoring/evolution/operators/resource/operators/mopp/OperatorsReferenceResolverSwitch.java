/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class OperatorsReferenceResolverSwitch implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private Map<Object, Object> options;
	
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.EObjectReferenceElementsReferenceResolver eObjectReferenceElementsReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.EObjectReferenceElementsReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.VariableReferenceReferencedVariableReferenceResolver variableReferenceReferencedVariableReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.VariableReferenceReferencedVariableReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.EStructuralFeatureQualifierStructuralFeatureReferenceResolver eStructuralFeatureQualifierStructuralFeatureReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.EStructuralFeatureQualifierStructuralFeatureReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.EOperationQualifierOperationReferenceResolver eOperationQualifierOperationReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.EOperationQualifierOperationReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.CREATEParentCompositeReferenceReferenceResolver cREATEParentCompositeReferenceReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.CREATEParentCompositeReferenceReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.TypeVariableTypeReferenceResolver typeVariableTypeReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.TypeVariableTypeReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.ASSIGNAttributeReferenceResolver aSSIGNAttributeReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.ASSIGNAttributeReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.SETReferenceReferenceResolver sETReferenceReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.SETReferenceReferenceResolver();
	protected org.modelrefactoring.evolution.operators.resource.operators.analysis.MOVEParentReferenceReferenceResolver mOVEParentReferenceReferenceResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.MOVEParentReferenceReferenceResolver();
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.EObjectReference, org.eclipse.emf.ecore.EObject> getEObjectReferenceElementsReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEObjectReference_Elements(), eObjectReferenceElementsReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.VariableReference, org.modelrefactoring.evolution.operators.Variable> getVariableReferenceReferencedVariableReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVariableReference_ReferencedVariable(), variableReferenceReferencedVariableReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier, org.eclipse.emf.ecore.EStructuralFeature> getEStructuralFeatureQualifierStructuralFeatureReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEStructuralFeatureQualifier_StructuralFeature(), eStructuralFeatureQualifierStructuralFeatureReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.EOperationQualifier, org.eclipse.emf.ecore.EOperation> getEOperationQualifierOperationReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEOperationQualifier_Operation(), eOperationQualifierOperationReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.CREATE, org.eclipse.emf.ecore.EReference> getCREATEParentCompositeReferenceReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE_ParentCompositeReference(), cREATEParentCompositeReferenceReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.TypeVariable, org.eclipse.emf.ecore.EClass> getTypeVariableTypeReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable_Type(), typeVariableTypeReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.ASSIGN, org.eclipse.emf.ecore.EAttribute> getASSIGNAttributeReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN_Attribute(), aSSIGNAttributeReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.SET, org.eclipse.emf.ecore.EReference> getSETReferenceReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET_Reference(), sETReferenceReferenceResolver);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.MOVE, org.eclipse.emf.ecore.EReference> getMOVEParentReferenceReferenceResolver() {
		return getResolverChain(org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE_ParentReference(), mOVEParentReferenceReferenceResolver);
	}
	
	public void setOptions(Map<?, ?> options) {
		if (options != null) {
			this.options = new LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		eObjectReferenceElementsReferenceResolver.setOptions(options);
		variableReferenceReferencedVariableReferenceResolver.setOptions(options);
		eStructuralFeatureQualifierStructuralFeatureReferenceResolver.setOptions(options);
		eOperationQualifierOperationReferenceResolver.setOptions(options);
		cREATEParentCompositeReferenceReferenceResolver.setOptions(options);
		typeVariableTypeReferenceResolver.setOptions(options);
		aSSIGNAttributeReferenceResolver.setOptions(options);
		sETReferenceReferenceResolver.setOptions(options);
		mOVEParentReferenceReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, EObject container, EReference reference, int position, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<EObject> result) {
		if (container == null) {
			return;
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEObjectReference().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EObject> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EObject>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("elements")) {
				eObjectReferenceElementsReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.EObjectReference) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVariableReference().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.modelrefactoring.evolution.operators.Variable> frr = new OperatorsFuzzyResolveResult<org.modelrefactoring.evolution.operators.Variable>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("referencedVariable")) {
				variableReferenceReferencedVariableReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.VariableReference) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEStructuralFeatureQualifier().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("structuralFeature")) {
				eStructuralFeatureQualifierStructuralFeatureReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.EStructuralFeatureQualifier) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEOperationQualifier().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EOperation> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EOperation>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("operation")) {
				eOperationQualifierOperationReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.EOperationQualifier) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EReference> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EReference>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("parentCompositeReference")) {
				cREATEParentCompositeReferenceReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.CREATE) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EClass> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EClass>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("type")) {
				typeVariableTypeReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.TypeVariable) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EAttribute> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EAttribute>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("attribute")) {
				aSSIGNAttributeReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.ASSIGN) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EReference> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EReference>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("reference")) {
				sETReferenceReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.SET) container, (EReference) feature, position, true, frr);
			}
		}
		if (org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE().isInstance(container)) {
			OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EReference> frr = new OperatorsFuzzyResolveResult<org.eclipse.emf.ecore.EReference>(result);
			String referenceName = reference.getName();
			EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof EReference && referenceName != null && referenceName.equals("parentReference")) {
				mOVEParentReferenceReferenceResolver.resolve(identifier, (org.modelrefactoring.evolution.operators.MOVE) container, (EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<? extends EObject, ? extends EObject> getResolver(EStructuralFeature reference) {
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEObjectReference_Elements()) {
			return getResolverChain(reference, eObjectReferenceElementsReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getVariableReference_ReferencedVariable()) {
			return getResolverChain(reference, variableReferenceReferencedVariableReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEStructuralFeatureQualifier_StructuralFeature()) {
			return getResolverChain(reference, eStructuralFeatureQualifierStructuralFeatureReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getEOperationQualifier_Operation()) {
			return getResolverChain(reference, eOperationQualifierOperationReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getCREATE_ParentCompositeReference()) {
			return getResolverChain(reference, cREATEParentCompositeReferenceReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getTypeVariable_Type()) {
			return getResolverChain(reference, typeVariableTypeReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getASSIGN_Attribute()) {
			return getResolverChain(reference, aSSIGNAttributeReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getSET_Reference()) {
			return getResolverChain(reference, sETReferenceReferenceResolver);
		}
		if (reference == org.modelrefactoring.evolution.operators.OperatorsPackage.eINSTANCE.getMOVE_ParentReference()) {
			return getResolverChain(reference, mOVEParentReferenceReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <ContainerType extends EObject, ReferenceType extends EObject> org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<ContainerType, ReferenceType> getResolverChain(EStructuralFeature reference, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof Map)) {
			// send this to the error log
			new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsRuntimeUtil().logWarning("Found value with invalid type for option " + org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		Map<?,?> resolverMap = (Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver) {
			org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver replacingResolver = (org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.modelrefactoring.evolution.operators.resource.operators.IOperatorsDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.modelrefactoring.evolution.operators.resource.operators.IOperatorsDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof Collection) {
			Collection replacingResolvers = (Collection) resolverValue;
			org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceCache) {
					org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver nextResolver = (org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver) next;
					if (nextResolver instanceof org.modelrefactoring.evolution.operators.resource.operators.IOperatorsDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.modelrefactoring.evolution.operators.resource.operators.IOperatorsDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.modelrefactoring.evolution.operators.resource.operators.IOperatorsDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.modelrefactoring.evolution.operators.resource.operators.IOperatorsOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.modelrefactoring.evolution.operators.resource.operators.IOperatorsDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
