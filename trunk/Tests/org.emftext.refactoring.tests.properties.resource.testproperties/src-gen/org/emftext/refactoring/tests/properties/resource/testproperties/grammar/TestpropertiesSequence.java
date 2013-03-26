/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

public class TestpropertiesSequence extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement {
	
	public TestpropertiesSequence(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesStringUtil.explode(getChildren(), " ");
	}
	
}
