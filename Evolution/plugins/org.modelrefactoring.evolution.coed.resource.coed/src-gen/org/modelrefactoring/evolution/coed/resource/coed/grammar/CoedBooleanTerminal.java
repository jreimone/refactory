/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class CoedBooleanTerminal extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public CoedBooleanTerminal(EStructuralFeature attribute, String trueLiteral, String falseLiteral, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, int mandatoryOccurrencesAfter) {
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
