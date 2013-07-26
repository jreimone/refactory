/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

public class GueryLineBreak extends org.modelrefactoring.guery.resource.guery.grammar.GueryFormattingElement {
	
	private final int tabs;
	
	public GueryLineBreak(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality cardinality, int tabs) {
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
