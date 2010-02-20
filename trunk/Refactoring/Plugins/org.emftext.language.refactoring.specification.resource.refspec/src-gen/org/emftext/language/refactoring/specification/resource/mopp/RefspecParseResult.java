/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecParseResult implements org.emftext.language.refactoring.specification.resource.IRefspecParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>> commands = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>>();
	
	public RefspecParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.refactoring.specification.resource.IRefspecCommand<org.emftext.language.refactoring.specification.resource.IRefspecTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
