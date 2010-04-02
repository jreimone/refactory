/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

// The abstract super class for all elements of a grammar.
// This class provides methods to traverse the grammar rules.
public abstract class RefspecSyntaxElement {
	
	private RefspecSyntaxElement[] children;
	private RefspecSyntaxElement parent;
	private org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality;
	
	public RefspecSyntaxElement(org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality, RefspecSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (RefspecSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(RefspecSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public RefspecSyntaxElement[] getChildren() {
		if (children == null) {
			return new RefspecSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality getCardinality() {
		return cardinality;
	}
	
}
