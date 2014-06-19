/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides information about how brackets must be handled in the
 * editor (e.g., whether they must be closed automatically).
 */
public class TestpropertiesBracketInformationProvider {
	
	public Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair> getBracketPairs() {
		Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair> result = new ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBracketPair>();
		result.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesBracketPair("[", "]", false, false));
		result.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesBracketPair("<", ">", false, false));
		result.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesBracketPair("\"", "\"", false, false));
		return result;
	}
	
}
