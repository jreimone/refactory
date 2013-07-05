/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class TestpropertiesBracketInformationProvider {
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair> result = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair>();
		result.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesBracketPair("[", "]", false, false));
		result.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesBracketPair("<", ">", false, false));
		result.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
