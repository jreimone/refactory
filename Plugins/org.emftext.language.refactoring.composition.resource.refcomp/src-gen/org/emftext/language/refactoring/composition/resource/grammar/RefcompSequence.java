/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;


public class RefcompSequence extends org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement {
	
	public RefcompSequence(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality, org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.refactoring.composition.resource.util.RefcompStringUtil.explode(getChildren(), " ");
	}
	
}
