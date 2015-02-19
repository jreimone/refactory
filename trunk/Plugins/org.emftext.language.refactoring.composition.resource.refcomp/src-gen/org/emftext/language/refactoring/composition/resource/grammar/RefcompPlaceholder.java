/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class RefcompPlaceholder extends org.emftext.language.refactoring.composition.resource.grammar.RefcompTerminal {
	
	private final String tokenName;
	
	public RefcompPlaceholder(EStructuralFeature feature, String tokenName, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
