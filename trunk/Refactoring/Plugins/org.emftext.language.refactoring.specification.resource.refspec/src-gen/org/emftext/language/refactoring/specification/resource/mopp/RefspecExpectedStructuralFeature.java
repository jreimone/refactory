/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

// A representation for a range in a document where a structural feature (e.g.,
// a reference) is expected.
public class RefspecExpectedStructuralFeature extends org.emftext.language.refactoring.specification.resource.mopp.RefspecAbstractExpectedElement {
	
	private org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder placeholder;
	
	public RefspecExpectedStructuralFeature(org.emftext.language.refactoring.specification.resource.grammar.RefspecPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.lang.String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(java.lang.Object o) {
		if (o instanceof RefspecExpectedStructuralFeature) {
			return getFeature().equals(((RefspecExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
