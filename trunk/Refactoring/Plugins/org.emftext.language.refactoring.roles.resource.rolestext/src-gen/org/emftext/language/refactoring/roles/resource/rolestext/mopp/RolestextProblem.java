/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextProblem implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextProblem {
	
	private java.lang.String message;
	private org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType type;
	
	public RolestextProblem(java.lang.String message, org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.RolestextEProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
