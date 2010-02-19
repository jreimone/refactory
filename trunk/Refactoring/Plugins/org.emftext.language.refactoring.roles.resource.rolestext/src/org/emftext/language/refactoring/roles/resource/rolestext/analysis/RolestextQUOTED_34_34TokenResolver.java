/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.analysis;

public class RolestextQUOTED_34_34TokenResolver implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolver {
	
	private org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultTokenResolver defaultTokenResolver = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "\"";
		result = "\"" + result;
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
