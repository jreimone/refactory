/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextParseResult implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>> commands = new java.util.ArrayList<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>>();
	
	public RolestextParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
