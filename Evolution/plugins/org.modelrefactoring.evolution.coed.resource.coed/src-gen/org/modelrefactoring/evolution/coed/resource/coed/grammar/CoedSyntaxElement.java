/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class CoedSyntaxElement {
	
	private CoedSyntaxElement[] children;
	private CoedSyntaxElement parent;
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality;
	
	public CoedSyntaxElement(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, CoedSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (CoedSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(CoedSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public CoedSyntaxElement getParent() {
		return parent;
	}
	
	public CoedSyntaxElement[] getChildren() {
		if (children == null) {
			return new CoedSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality getCardinality() {
		return cardinality;
	}
	
}
