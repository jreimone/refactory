/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

public class OperatorsTerminal extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement {
	
	private final EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public OperatorsTerminal(EStructuralFeature feature, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}
