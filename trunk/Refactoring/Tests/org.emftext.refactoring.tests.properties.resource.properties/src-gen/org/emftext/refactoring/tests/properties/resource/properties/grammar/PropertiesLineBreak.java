/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

public class PropertiesLineBreak extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement {
	
	private final int tabs;
	
	public PropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality, int tabs) {
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
