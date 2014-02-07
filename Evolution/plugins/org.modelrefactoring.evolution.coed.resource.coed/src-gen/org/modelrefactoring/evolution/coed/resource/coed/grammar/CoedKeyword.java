/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class CoedKeyword extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement {
	
	private final String value;
	
	public CoedKeyword(String value, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality) {
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
