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
	
	private final java.lang.String tokenName;
	
	public PropertiesPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, java.lang.String tokenName, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public java.lang.String getTokenName() {
		return tokenName;
	}
	
}
