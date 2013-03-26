/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

public class TestpropertiesLineBreak extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesFormattingElement {
	
	private final int tabs;
	
	public TestpropertiesLineBreak(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality, int tabs) {
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
