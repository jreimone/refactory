/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;


public class OperatorsCompound extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement {
	
	public OperatorsCompound(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsChoice choice, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality) {
		super(cardinality, new org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
