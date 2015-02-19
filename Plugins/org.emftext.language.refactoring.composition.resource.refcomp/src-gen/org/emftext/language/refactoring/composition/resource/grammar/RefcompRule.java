/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class RefcompRule extends org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement {
	
	private final EClass metaclass;
	
	public RefcompRule(EClass metaclass, org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice choice, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality) {
		super(cardinality, new org.emftext.language.refactoring.composition.resource.grammar.RefcompSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice getDefinition() {
		return (org.emftext.language.refactoring.composition.resource.grammar.RefcompChoice) getChildren()[0];
	}
	
}

