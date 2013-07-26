/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

public class GueryChoice extends org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement {
	
	public GueryChoice(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality cardinality, org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.modelrefactoring.guery.resource.guery.util.GueryStringUtil.explode(getChildren(), "|");
	}
	
}
