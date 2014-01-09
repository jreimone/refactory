/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.analysis;

public class GueryCARDINALITYTokenResolver implements org.qualitune.guery.resource.guery.IGueryTokenResolver {
	
	private org.qualitune.guery.resource.guery.analysis.GueryDefaultTokenResolver defaultTokenResolver = new org.qualitune.guery.resource.guery.analysis.GueryDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return ("-1".equals(result))? "*" : result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.qualitune.guery.resource.guery.IGueryTokenResolveResult result) {
		if("*".equals(lexem)){
			defaultTokenResolver.resolve("-1", feature, result);
		} else {
			defaultTokenResolver.resolve(lexem, feature, result);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
