/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class RefcompTokenResolveResult implements org.emftext.language.refactoring.composition.resource.IRefcompTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public RefcompTokenResolveResult() {
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
