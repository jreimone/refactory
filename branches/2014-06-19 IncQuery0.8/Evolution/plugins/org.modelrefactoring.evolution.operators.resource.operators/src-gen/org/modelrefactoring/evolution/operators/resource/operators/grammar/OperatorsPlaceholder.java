/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent placeholders in a grammar.
 */
public class OperatorsPlaceholder extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsTerminal {
	
	private final String tokenName;
	
	public OperatorsPlaceholder(EStructuralFeature feature, String tokenName, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
