/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class GueryPlaceholder extends org.modelrefactoring.guery.resource.guery.grammar.GueryTerminal {
	
	private final String tokenName;
	
	public GueryPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
