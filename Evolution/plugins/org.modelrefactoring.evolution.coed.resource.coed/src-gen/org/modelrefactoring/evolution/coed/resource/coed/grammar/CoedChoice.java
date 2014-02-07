/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;


public class CoedChoice extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement {
	
	public CoedChoice(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.modelrefactoring.evolution.coed.resource.coed.util.CoedStringUtil.explode(getChildren(), "|");
	}
	
}
