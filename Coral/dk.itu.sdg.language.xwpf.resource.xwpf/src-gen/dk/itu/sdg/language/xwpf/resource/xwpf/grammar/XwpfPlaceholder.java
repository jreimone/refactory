/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class XwpfPlaceholder extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfTerminal {
	
	private final String tokenName;
	
	public XwpfPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
