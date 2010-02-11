/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.analysis;

public class RolestextRUNTIMETokenResolver implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver {
	
	private org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultTokenResolver defaultTokenResolver = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		if("true".equals(value)){
			return "runtime";
		}
		if(Boolean.TRUE.equals(value)){
			return "runtime";
		}
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result) {
		if("runtime".equals(lexem)){
			defaultTokenResolver.resolve("true", feature, result);
		} else {
			defaultTokenResolver.resolve(lexem, feature, result);
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
