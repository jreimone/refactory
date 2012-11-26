/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class XwpfSyntaxElement {
	
	private XwpfSyntaxElement[] children;
	private XwpfSyntaxElement parent;
	private dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality;
	
	public XwpfSyntaxElement(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality, XwpfSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (XwpfSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(XwpfSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public XwpfSyntaxElement getParent() {
		return parent;
	}
	
	public XwpfSyntaxElement[] getChildren() {
		if (children == null) {
			return new XwpfSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality getCardinality() {
		return cardinality;
	}
	
}
