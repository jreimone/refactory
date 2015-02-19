/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;


public class RefcompChoice extends org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement {
	
	public RefcompChoice(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality, org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.refactoring.composition.resource.util.RefcompStringUtil.explode(getChildren(), "|");
	}
	
}
