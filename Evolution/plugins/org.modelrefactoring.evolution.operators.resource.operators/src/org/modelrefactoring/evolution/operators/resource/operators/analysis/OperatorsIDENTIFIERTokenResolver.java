/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class OperatorsIDENTIFIERTokenResolver implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolver {
	
	private org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultTokenResolver defaultTokenResolver = new org.modelrefactoring.evolution.operators.resource.operators.analysis.OperatorsDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
