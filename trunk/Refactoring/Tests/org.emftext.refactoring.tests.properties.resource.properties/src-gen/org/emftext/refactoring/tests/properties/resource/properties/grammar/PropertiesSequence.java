/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

public class PropertiesSequence extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement {
	
	public PropertiesSequence(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesStringUtil.explode(getChildren(), " ");
	}
	
}
