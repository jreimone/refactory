/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecProblem implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecProblem {
	
	private java.lang.String message;
	private org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType type;
	
	public RefspecProblem(java.lang.String message, org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.language.refactoring.refactoring_specification.resource.refspec.RefspecEProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
