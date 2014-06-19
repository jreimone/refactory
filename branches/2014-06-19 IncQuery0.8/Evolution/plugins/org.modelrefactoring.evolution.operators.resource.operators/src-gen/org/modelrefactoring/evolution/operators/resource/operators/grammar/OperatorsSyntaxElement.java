/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class OperatorsSyntaxElement {
	
	private OperatorsSyntaxElement[] children;
	private OperatorsSyntaxElement parent;
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality;
	
	public OperatorsSyntaxElement(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, OperatorsSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (OperatorsSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(OperatorsSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public OperatorsSyntaxElement getParent() {
		return parent;
	}
	
	public OperatorsSyntaxElement[] getChildren() {
		if (children == null) {
			return new OperatorsSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality getCardinality() {
		return cardinality;
	}
	
}
