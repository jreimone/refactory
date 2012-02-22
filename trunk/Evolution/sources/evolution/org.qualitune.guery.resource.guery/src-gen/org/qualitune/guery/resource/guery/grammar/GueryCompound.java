/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.grammar;

public class GueryCompound extends org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement {
	
	public GueryCompound(org.qualitune.guery.resource.guery.grammar.GueryChoice choice, org.qualitune.guery.resource.guery.grammar.GueryCardinality cardinality) {
		super(cardinality, new org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
