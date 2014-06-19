/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class OperatorsKeyword extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement {
	
	private final String value;
	
	public OperatorsKeyword(String value, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality) {
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
