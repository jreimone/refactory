/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class PropertiesRule extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public PropertiesRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice choice, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality) {
		super(cardinality, new org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice getDefinition() {
		return (org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesChoice) getChildren()[0];
	}
	
}

