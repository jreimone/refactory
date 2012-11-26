/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

public class XwpfChoice extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement {
	
	public XwpfChoice(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.explode(getChildren(), "|");
	}
	
}
