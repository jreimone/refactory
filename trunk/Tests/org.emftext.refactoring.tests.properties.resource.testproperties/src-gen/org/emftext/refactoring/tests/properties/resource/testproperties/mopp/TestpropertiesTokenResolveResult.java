/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class TestpropertiesTokenResolveResult implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public TestpropertiesTokenResolveResult() {
		super();
		clear();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Object getResolvedToken() {
		return resolvedToken;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void setResolvedToken(Object resolvedToken) {
		this.resolvedToken = resolvedToken;
	}
	
	public void clear() {
		errorMessage = "Can't resolve token.";
		resolvedToken = null;
	}
	
}
