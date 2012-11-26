/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

public class XwpfCompound extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement {
	
	public XwpfCompound(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfChoice choice, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality) {
		super(cardinality, new dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
