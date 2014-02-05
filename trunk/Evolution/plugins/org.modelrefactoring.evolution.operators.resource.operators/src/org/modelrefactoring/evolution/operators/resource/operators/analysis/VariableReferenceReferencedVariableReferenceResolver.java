/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import org.eclipse.emf.ecore.EReference;
import org.modelrefactoring.evolution.operators.Variable;
import org.modelrefactoring.evolution.operators.VariableReference;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver;

public class VariableReferenceReferencedVariableReferenceResolver implements IOperatorsReferenceResolver<VariableReference, Variable> {
	
	private OperatorsDefaultResolverDelegate<VariableReference, Variable> delegate = new OperatorsDefaultResolverDelegate<VariableReference, Variable>();
	
	public void resolve(String identifier, VariableReference variableReference, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<Variable> result) {
		delegate.resolve(identifier, variableReference, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(Variable variable, VariableReference container, EReference reference) {
		return variable.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
