/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

public class PropertiesCompound extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement {
	
	public PropertiesCompound(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice choice, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality) {
		super(cardinality, new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
