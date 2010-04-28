/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

public class PropertiesWhiteSpace extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesFormattingElement {
	
	private final int amount;
	
	public PropertiesWhiteSpace(int amount, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
}
