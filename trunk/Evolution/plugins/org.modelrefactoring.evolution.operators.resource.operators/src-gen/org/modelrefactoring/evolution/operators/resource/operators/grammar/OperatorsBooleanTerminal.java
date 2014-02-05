/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class OperatorsBooleanTerminal extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public OperatorsBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof EAttribute;
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	public String getTrueLiteral() {
		return trueLiteral;
	}
	
	public String getFalseLiteral() {
		return falseLiteral;
	}
	
	public EAttribute getAttribute() {
		return (EAttribute) getFeature();
	}
	
}
