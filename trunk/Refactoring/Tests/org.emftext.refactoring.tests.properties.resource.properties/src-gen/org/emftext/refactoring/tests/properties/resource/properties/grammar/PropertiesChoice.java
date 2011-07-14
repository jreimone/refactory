/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

public class PropertiesChoice extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement {
	
	public PropertiesChoice(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesStringUtil.explode(getChildren(), "|");
	}
	
}
