/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;


/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class OperatorsTokenResolveResult implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public OperatorsTokenResolveResult() {
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
