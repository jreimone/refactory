/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.modelrefactoring.guery.resource.guery.IGueryTokenResolveResult;

public class GueryCARDINALITYTokenResolver implements org.modelrefactoring.guery.resource.guery.IGueryTokenResolver {
	
	private org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultTokenResolver defaultTokenResolver = new org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return ("-1".equals(result))? "*" : result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, IGueryTokenResolveResult result) {
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
