/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class GueryKeyword extends org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement {
	
	private final String value;
	
	public GueryKeyword(String value, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality cardinality) {
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
