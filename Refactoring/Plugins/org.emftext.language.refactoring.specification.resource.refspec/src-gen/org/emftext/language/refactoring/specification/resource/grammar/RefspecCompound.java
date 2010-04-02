/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

public class RefspecCompound extends org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement {
	
	public RefspecCompound(org.emftext.language.refactoring.specification.resource.grammar.RefspecChoice choice, org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality) {
		super(cardinality, new org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement[] {choice});
	}
	
}
