/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.grammar;

public class GueryChoice extends org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement {
	
	public GueryChoice(org.qualitune.guery.resource.guery.grammar.GueryCardinality cardinality, org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.qualitune.guery.resource.guery.util.GueryStringUtil.explode(getChildren(), "|");
	}
	
}
