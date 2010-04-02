/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

public class RefspecLineBreak extends org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement {
	
	private final int tabs;
	
	public RefspecLineBreak(org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
}
