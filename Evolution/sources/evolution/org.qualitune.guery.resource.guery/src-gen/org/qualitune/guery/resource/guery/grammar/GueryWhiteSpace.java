/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.grammar;

public class GueryWhiteSpace extends org.qualitune.guery.resource.guery.grammar.GueryFormattingElement {
	
	private final int amount;
	
	public GueryWhiteSpace(int amount, org.qualitune.guery.resource.guery.grammar.GueryCardinality cardinality) {
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
