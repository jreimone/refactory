/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;


/**
 * A class to represent a keyword in the grammar.
 */
public class RefcompKeyword extends org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement {
	
	private final String value;
	
	public RefcompKeyword(String value, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
