/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

public class XwpfSequence extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement {
	
	public XwpfSequence(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return dk.itu.sdg.language.xwpf.resource.xwpf.util.XwpfStringUtil.explode(getChildren(), " ");
	}
	
}
