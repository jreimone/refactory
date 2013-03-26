/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class TestpropertiesKeyword extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement {
	
	private final String value;
	
	public TestpropertiesKeyword(String value, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
