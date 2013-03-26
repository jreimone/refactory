/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class TestpropertiesSyntaxElement {
	
	private TestpropertiesSyntaxElement[] children;
	private TestpropertiesSyntaxElement parent;
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality;
	
	public TestpropertiesSyntaxElement(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality, TestpropertiesSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (TestpropertiesSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(TestpropertiesSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public TestpropertiesSyntaxElement getParent() {
		return parent;
	}
	
	public TestpropertiesSyntaxElement[] getChildren() {
		if (children == null) {
			return new TestpropertiesSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality getCardinality() {
		return cardinality;
	}
	
}
