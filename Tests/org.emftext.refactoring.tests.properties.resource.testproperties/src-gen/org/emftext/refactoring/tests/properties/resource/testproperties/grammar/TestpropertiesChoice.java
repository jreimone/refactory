/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

public class TestpropertiesChoice extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement {
	
	public TestpropertiesChoice(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesStringUtil.explode(getChildren(), "|");
	}
	
}
