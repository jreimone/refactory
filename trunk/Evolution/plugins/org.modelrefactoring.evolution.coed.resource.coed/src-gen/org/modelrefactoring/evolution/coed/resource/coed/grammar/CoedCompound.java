/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;


public class CoedCompound extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement {
	
	public CoedCompound(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedChoice choice, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality) {
		super(cardinality, new org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
