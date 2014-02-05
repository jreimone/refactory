/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;


public class OperatorsChoice extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement {
	
	public OperatorsChoice(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsStringUtil.explode(getChildren(), "|");
	}
	
}
