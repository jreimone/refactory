/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.ArrayList;
import java.util.List;

public class OperatorsSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private OperatorsSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private List<Integer> indicesToPrint = new ArrayList<Integer>();
	
	public OperatorsSyntaxElementDecorator(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement decoratedElement, OperatorsSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public OperatorsSyntaxElementDecorator[] getChildDecorators() {
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
