/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class CoedRule extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement {
	
	private final EClass metaclass;
	
	public CoedRule(EClass metaclass, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice choice, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality) {
		super(cardinality, new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice getDefinition() {
		return (org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice) getChildren()[0];
	}
	
}

