/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.analysis;


public class GueryIDENTIFIERTokenResolver implements org.modelrefactoring.guery.resource.guery.IGueryTokenResolver {
	
	private org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultTokenResolver defaultTokenResolver = new org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
