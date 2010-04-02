/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.grammar;

public class RefspecContainment extends org.emftext.language.refactoring.specification.resource.grammar.RefspecSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	
	public RefspecContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.refactoring.specification.resource.grammar.RefspecCardinality cardinality) {
		super(cardinality, null);
		this.feature = feature;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
}
