/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

public class RolemappingLOWER_IDENTIFIERTokenResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingTokenResolver {
	
	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultTokenResolver defaultTokenResolver = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
