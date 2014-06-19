/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;


public class CoedSequence extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement {
	
	public CoedSequence(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.modelrefactoring.evolution.coed.resource.coed.util.CoedStringUtil.explode(getChildren(), " ");
	}
	
}
