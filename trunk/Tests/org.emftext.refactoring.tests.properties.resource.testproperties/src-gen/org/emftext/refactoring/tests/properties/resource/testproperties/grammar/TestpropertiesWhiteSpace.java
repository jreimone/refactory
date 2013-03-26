/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

public class TestpropertiesWhiteSpace extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesFormattingElement {
	
	private final int amount;
	
	public TestpropertiesWhiteSpace(int amount, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality) {
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
