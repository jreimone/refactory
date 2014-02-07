/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;


public class CoedLineBreak extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedFormattingElement {
	
	private final int tabs;
	
	public CoedLineBreak(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, int tabs) {
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
