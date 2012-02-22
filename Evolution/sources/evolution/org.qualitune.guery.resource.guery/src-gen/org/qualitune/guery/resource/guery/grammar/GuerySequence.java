/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.grammar;

public class GuerySequence extends org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement {
	
	public GuerySequence(org.qualitune.guery.resource.guery.grammar.GueryCardinality cardinality, org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.qualitune.guery.resource.guery.util.GueryStringUtil.explode(getChildren(), " ");
	}
	
}
