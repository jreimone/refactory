/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

// A class to represent placeholders in a grammar.
public class RefspecPlaceholder extends org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	private final java.lang.String tokenName;
	
	public RefspecPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, java.lang.String tokenName, org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality) {
		super(cardinality, null);
		this.feature = feature;
		this.tokenName = tokenName;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public java.lang.String getTokenName() {
		return tokenName;
	}
	
}
