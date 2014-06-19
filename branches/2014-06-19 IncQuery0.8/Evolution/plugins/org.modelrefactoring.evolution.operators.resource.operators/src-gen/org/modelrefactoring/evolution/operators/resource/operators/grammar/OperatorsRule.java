/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class OperatorsRule extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement {
	
	private final EClass metaclass;
	
	public OperatorsRule(EClass metaclass, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice choice, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality) {
		super(cardinality, new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice getDefinition() {
		return (org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice) getChildren()[0];
	}
	
}

