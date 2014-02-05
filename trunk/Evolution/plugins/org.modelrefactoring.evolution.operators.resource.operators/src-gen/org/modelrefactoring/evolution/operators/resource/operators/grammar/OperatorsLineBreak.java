/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;


public class OperatorsLineBreak extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsFormattingElement {
	
	private final int tabs;
	
	public OperatorsLineBreak(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
