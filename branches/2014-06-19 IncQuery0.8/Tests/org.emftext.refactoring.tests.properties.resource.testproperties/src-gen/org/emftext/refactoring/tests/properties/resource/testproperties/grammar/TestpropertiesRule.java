/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class TestpropertiesRule extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement {
	
	private final EClass metaclass;
	
	public TestpropertiesRule(EClass metaclass, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice choice, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality) {
		super(cardinality, new org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice getDefinition() {
		return (org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesChoice) getChildren()[0];
	}
	
}

