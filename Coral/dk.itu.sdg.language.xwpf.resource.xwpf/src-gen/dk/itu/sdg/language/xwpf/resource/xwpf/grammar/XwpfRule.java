/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class XwpfRule extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public XwpfRule(org.eclipse.emf.ecore.EClass metaclass, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfChoice choice, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality) {
		super(cardinality, new dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfChoice getDefinition() {
		return (dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfChoice) getChildren()[0];
	}
	
}

