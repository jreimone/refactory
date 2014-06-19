/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class CoedPlaceholder extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedTerminal {
	
	private final String tokenName;
	
	public CoedPlaceholder(EStructuralFeature feature, String tokenName, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
