/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class PropertiesPlaceholder extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesTerminal {
	
	private final String tokenName;
	
	public PropertiesPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
