/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;


public class CoedWhiteSpace extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedFormattingElement {
	
	private final int amount;
	
	public CoedWhiteSpace(int amount, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality) {
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
