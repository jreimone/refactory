/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

public class TestpropertiesParseResult implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap;
	
	private java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>> commands = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>>();
	
	public TestpropertiesParseResult() {
		super();
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
