/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

// A class to represent a keyword in the grammar.
public class RefspecKeyword extends org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement {
	
	private final String value;
	
	public RefspecKeyword(String value, org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
