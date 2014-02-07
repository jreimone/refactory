/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class CoedIDENTIFIERTokenResolver implements org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolver {
	
	private org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultTokenResolver defaultTokenResolver = new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
