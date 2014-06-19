/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.analysis;

public class TestpropertiesTEXTTokenResolver implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolver {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultTokenResolver defaultTokenResolver = new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
