/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;


public class RefcompLineBreak extends org.emftext.language.refactoring.composition.resource.grammar.RefcompFormattingElement {
	
	private final int tabs;
	
	public RefcompLineBreak(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality, int tabs) {
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
