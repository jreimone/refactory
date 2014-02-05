/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import org.eclipse.emf.ecore.EReference;

public class TypeVariableTypeReferenceResolver implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver<org.modelrefactoring.evolution.operators.TypeVariable, org.eclipse.emf.ecore.EClass> {
	
	private org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultResolverDelegate<org.modelrefactoring.evolution.operators.TypeVariable, org.eclipse.emf.ecore.EClass> delegate = new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultResolverDelegate<org.modelrefactoring.evolution.operators.TypeVariable, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(String identifier, org.modelrefactoring.evolution.operators.TypeVariable container, EReference reference, int position, boolean resolveFuzzy, final org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EClass element, org.modelrefactoring.evolution.operators.TypeVariable container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
