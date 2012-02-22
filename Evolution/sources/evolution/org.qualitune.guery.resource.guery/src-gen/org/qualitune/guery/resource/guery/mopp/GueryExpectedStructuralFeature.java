/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class GueryExpectedStructuralFeature extends org.qualitune.guery.resource.guery.mopp.GueryAbstractExpectedElement {
	
	private org.qualitune.guery.resource.guery.grammar.GueryPlaceholder placeholder;
	
	public GueryExpectedStructuralFeature(org.qualitune.guery.resource.guery.grammar.GueryPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement getSymtaxElement() {
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
		if (o instanceof GueryExpectedStructuralFeature) {
			return getFeature().equals(((GueryExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
