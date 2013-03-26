/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

public class TestpropertiesCompound extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement {
	
	public TestpropertiesCompound(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice choice, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality) {
		super(cardinality, new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
