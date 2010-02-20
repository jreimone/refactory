/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecProblem implements org.emftext.language.refactoring.specification.resource.IRefspecProblem {
	
	private java.lang.String message;
	private org.emftext.language.refactoring.specification.resource.RefspecEProblemType type;
	
	public RefspecProblem(java.lang.String message, org.emftext.language.refactoring.specification.resource.RefspecEProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.language.refactoring.specification.resource.RefspecEProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
