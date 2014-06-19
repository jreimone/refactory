/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

public class GuerySequence extends org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement {
	
	public GuerySequence(org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality cardinality, org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.modelrefactoring.guery.resource.guery.util.GueryStringUtil.explode(getChildren(), " ");
	}
	
}
