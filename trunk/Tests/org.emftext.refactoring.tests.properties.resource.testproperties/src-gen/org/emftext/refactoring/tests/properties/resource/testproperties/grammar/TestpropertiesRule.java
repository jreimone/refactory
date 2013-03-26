/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class TestpropertiesRule extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public TestpropertiesRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice choice, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality) {
		super(cardinality, new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getDefinition() {
		return (org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice) getChildren()[0];
	}
	
}

