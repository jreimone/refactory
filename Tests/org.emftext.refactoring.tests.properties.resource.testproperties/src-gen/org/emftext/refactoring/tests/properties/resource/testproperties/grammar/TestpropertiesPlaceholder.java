/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class TestpropertiesPlaceholder extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesTerminal {
	
	private final String tokenName;
	
	public TestpropertiesPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
