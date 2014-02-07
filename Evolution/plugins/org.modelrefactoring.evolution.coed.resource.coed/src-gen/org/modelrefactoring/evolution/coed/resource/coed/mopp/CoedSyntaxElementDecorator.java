/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.ArrayList;
import java.util.List;

public class CoedSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private CoedSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public CoedSyntaxElementDecorator(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement decoratedElement, CoedSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public CoedSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
