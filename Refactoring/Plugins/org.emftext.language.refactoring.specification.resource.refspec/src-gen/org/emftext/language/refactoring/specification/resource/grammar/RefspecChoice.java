/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

public class RefspecChoice extends org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement {
	
	public RefspecChoice(org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality, org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
}
