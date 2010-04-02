/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

public class RefspecWhiteSpace extends org.emftext.language.refactoring.specification.resource.grammar.RefspecFormattingElement {
	
	private final int amount;
	
	public RefspecWhiteSpace(int amount, org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
}
