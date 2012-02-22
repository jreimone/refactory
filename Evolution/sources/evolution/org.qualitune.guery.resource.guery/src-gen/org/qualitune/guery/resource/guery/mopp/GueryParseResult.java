/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

public class GueryParseResult implements org.qualitune.guery.resource.guery.IGueryParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>> commands = new java.util.ArrayList<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>>();
	
	public GueryParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.qualitune.guery.resource.guery.IGueryCommand<org.qualitune.guery.resource.guery.IGueryTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
