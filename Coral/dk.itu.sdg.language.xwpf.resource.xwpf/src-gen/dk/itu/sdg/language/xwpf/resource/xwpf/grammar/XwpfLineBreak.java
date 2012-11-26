/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

public class XwpfLineBreak extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfFormattingElement {
	
	private final int tabs;
	
	public XwpfLineBreak(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
