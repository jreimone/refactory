/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

// Abstract super class for all expected elements. Provides methods to
// add followers
public abstract class RefspecAbstractExpectedElement implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecPair<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecPair<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public RefspecAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecPair<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecPair<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
