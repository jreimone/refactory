/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecParseResult implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecCommand<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource>> commands = new java.util.ArrayList<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecCommand<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource>>();
	
	public RefspecParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecCommand<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
