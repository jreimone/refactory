/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;

public class TestpropertiesParseResult implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesParseResult {
	
	private EObject root;
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap;
	
	private Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>> commands = new ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>>();
	
	public TestpropertiesParseResult() {
		super();
	}
	
	public EObject getRoot() {
		return root;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap getLocationMap() {
		return locationMap;
	}
	
	public void setRoot(EObject root) {
		this.root = root;
	}
	
	public void setLocationMap(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesLocationMap locationMap) {
		this.locationMap = locationMap;
	}
	
	public Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesCommand<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
