/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class PropertiesSyntaxElement {
	
	private PropertiesSyntaxElement[] children;
	private PropertiesSyntaxElement parent;
	private org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality;
	
	public PropertiesSyntaxElement(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality, PropertiesSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (PropertiesSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(PropertiesSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public PropertiesSyntaxElement getParent() {
		return parent;
	}
	
	public PropertiesSyntaxElement[] getChildren() {
		if (children == null) {
			return new PropertiesSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality getCardinality() {
		return cardinality;
	}
	
}
