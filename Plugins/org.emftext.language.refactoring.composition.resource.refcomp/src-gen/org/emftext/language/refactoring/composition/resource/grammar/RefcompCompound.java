/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;


public class RefcompCompound extends org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement {
	
	public RefcompCompound(org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice choice, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality) {
		super(cardinality, new org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
