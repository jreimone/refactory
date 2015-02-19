/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class RefcompSyntaxElement {
	
	private RefcompSyntaxElement[] children;
	private RefcompSyntaxElement parent;
	private org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality;
	
	public RefcompSyntaxElement(org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality, RefcompSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (RefcompSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(RefcompSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public RefcompSyntaxElement getParent() {
		return parent;
	}
	
	public RefcompSyntaxElement[] getChildren() {
		if (children == null) {
			return new RefcompSyntaxElement[0];
		}
		return children;
	}
	
	public EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality getCardinality() {
		return cardinality;
	}
	
}
