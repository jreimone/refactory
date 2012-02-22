/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class GuerySyntaxElement {
	
	private GuerySyntaxElement[] children;
	private GuerySyntaxElement parent;
	private org.qualitune.guery.resource.guery.grammar.GueryCardinality cardinality;
	
	public GuerySyntaxElement(org.qualitune.guery.resource.guery.grammar.GueryCardinality cardinality, GuerySyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (GuerySyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(GuerySyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public GuerySyntaxElement getParent() {
		return parent;
	}
	
	public GuerySyntaxElement[] getChildren() {
		if (children == null) {
			return new GuerySyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.qualitune.guery.resource.guery.grammar.GueryCardinality getCardinality() {
		return cardinality;
	}
	
}
