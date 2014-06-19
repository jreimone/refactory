/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

public class GueryCompound extends org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement {
	
	public GueryCompound(org.modelrefactoring.guery.resource.guery.grammar.GueryChoice choice, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality cardinality) {
		super(cardinality, new org.modelrefactoring.guery.resource.guery.grammar.GuerySyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
