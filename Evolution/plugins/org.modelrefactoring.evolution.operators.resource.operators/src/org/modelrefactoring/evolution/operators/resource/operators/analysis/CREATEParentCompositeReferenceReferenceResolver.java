/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import org.eclipse.emf.ecore.EReference;

public class CREATEParentCompositeReferenceReferenceResolver implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.CREATE, org.eclipse.emf.ecore.EReference> {
	
	private org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultResolverDelegate<org.modelrefactoring.evolution.operators.CREATE, org.eclipse.emf.ecore.EReference> delegate = new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultResolverDelegate<org.modelrefactoring.evolution.operators.CREATE, org.eclipse.emf.ecore.EReference>();
	
	public void resolve(String identifier, org.modelrefactoring.evolution.operators.CREATE container, EReference reference, int position, boolean resolveFuzzy, final org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EReference element, org.modelrefactoring.evolution.operators.CREATE container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
