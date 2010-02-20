/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

// A representation for a range in a document where a structural feature (e.g.,
// a reference) is expected.
public class RefspecExpectedStructuralFeature extends org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecAbstractExpectedElement {
	private org.eclipse.emf.ecore.EStructuralFeature feature;
	private String tokenName;
	
	public RefspecExpectedStructuralFeature(org.eclipse.emf.ecore.EClass ruleMetaclass, org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName) {
		super(ruleMetaclass);
		this.feature = feature;
		this.tokenName = tokenName;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
	public java.lang.String toString() {
		return "EFeature " + feature.getEContainingClass().getName() + "." + feature.getName();
	}
	
	public boolean equals(java.lang.Object o) {
		if (o instanceof RefspecExpectedStructuralFeature) {
			return this.feature.equals(((RefspecExpectedStructuralFeature) o).feature);
		}
		return false;
	}
}
