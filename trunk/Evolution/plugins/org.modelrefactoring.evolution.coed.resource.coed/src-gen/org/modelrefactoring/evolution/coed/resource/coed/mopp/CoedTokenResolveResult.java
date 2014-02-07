/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class CoedTokenResolveResult implements org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public CoedTokenResolveResult() {
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
