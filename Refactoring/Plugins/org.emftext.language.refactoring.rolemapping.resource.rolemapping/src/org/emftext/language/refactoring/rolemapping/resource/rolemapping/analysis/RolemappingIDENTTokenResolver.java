/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

public class RolemappingIDENTTokenResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingTokenResolver {
	
	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultTokenResolver defaultTokenResolver = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
