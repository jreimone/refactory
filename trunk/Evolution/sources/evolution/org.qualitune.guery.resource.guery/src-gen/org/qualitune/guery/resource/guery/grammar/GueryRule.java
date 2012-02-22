/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class GueryRule extends org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public GueryRule(org.eclipse.emf.ecore.EClass metaclass, org.qualitune.guery.resource.guery.grammar.GueryChoice choice, org.qualitune.guery.resource.guery.grammar.GueryCardinality cardinality) {
		super(cardinality, new org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.qualitune.guery.resource.guery.grammar.GueryChoice getDefinition() {
		return (org.qualitune.guery.resource.guery.grammar.GueryChoice) getChildren()[0];
	}
	
}

