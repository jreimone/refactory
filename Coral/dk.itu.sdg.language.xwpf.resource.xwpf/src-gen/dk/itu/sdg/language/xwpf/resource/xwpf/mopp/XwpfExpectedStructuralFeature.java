/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class XwpfExpectedStructuralFeature extends dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfAbstractExpectedElement {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfPlaceholder placeholder;
	
	public XwpfExpectedStructuralFeature(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof XwpfExpectedStructuralFeature) {
			return getFeature().equals(((XwpfExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
