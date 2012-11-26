/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private XwpfSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public XwpfSyntaxElementDecorator(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement decoratedElement, XwpfSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public XwpfSyntaxElementDecorator[] getChildDecorators() {
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
