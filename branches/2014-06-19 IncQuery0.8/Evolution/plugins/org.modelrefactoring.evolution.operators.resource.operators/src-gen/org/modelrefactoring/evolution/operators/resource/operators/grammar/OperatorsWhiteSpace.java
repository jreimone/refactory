/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;


public class OperatorsWhiteSpace extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsFormattingElement {
	
	private final int amount;
	
	public OperatorsWhiteSpace(int amount, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
