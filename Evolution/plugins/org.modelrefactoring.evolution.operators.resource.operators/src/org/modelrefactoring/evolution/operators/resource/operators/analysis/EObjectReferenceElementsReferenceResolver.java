/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import org.eclipse.emf.ecore.EReference;

public class EObjectReferenceElementsReferenceResolver implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.EObjectReference, org.eclipse.emf.ecore.EObject> {
	
	private org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultResolverDelegate<org.modelrefactoring.evolution.operators.EObjectReference, org.eclipse.emf.ecore.EObject> delegate = new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultResolverDelegate<org.modelrefactoring.evolution.operators.EObjectReference, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, org.modelrefactoring.evolution.operators.EObjectReference container, EReference reference, int position, boolean resolveFuzzy, final org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, org.modelrefactoring.evolution.operators.EObjectReference container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
