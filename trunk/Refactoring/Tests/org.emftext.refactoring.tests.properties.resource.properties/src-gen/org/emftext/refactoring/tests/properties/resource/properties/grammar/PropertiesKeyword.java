/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class PropertiesKeyword extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement {
	
	private final String value;
	
	public PropertiesKeyword(String value, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality) {
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
