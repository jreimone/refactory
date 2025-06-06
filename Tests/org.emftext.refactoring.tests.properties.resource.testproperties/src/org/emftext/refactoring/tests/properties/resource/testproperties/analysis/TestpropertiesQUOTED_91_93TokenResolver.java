/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.analysis;

public class TestpropertiesQUOTED_91_93TokenResolver implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultTokenResolver defaultTokenResolver = new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result += "]";
		result = "[" + result;
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolveResult result) {
		lexem = lexem.substring(1);
		lexem = lexem.substring(0, lexem.length() - 1);
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
