/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

// A basic implementation of the ITokenResolveResult interface.
//
public class RolestextTokenResolveResult implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public RolestextTokenResolveResult() {
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
