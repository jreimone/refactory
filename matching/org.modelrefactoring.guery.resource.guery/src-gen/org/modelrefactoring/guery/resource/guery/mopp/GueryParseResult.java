/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryParseResult implements org.modelrefactoring.guery.resource.guery.IGueryParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	
	private org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap;
	
	private java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>> commands = new java.util.ArrayList<org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>>();
	
	public GueryParseResult() {
		super();
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.modelrefactoring.guery.resource.guery.IGueryLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public java.util.Collection<org.modelrefactoring.guery.resource.guery.IGueryCommand<org.modelrefactoring.guery.resource.guery.IGueryTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
