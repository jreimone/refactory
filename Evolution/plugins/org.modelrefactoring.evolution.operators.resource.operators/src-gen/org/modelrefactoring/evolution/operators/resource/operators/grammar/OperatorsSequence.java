/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;


public class OperatorsSequence extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement {
	
	public OperatorsSequence(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsStringUtil.explode(getChildren(), " ");
	}
	
}
