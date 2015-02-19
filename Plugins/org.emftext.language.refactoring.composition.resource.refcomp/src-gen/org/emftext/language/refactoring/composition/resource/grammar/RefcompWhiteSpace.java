/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;


public class RefcompWhiteSpace extends org.emftext.language.refactoring.composition.resource.grammar.RefcompFormattingElement {
	
	private final int amount;
	
	public RefcompWhiteSpace(int amount, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality) {
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
