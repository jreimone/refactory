/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource;

// An element that is expected at a given position in a resource
// stream.
public interface IRefspecExpectedElement {
	
	public java.lang.String getTokenName();
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	public void addFollower(org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path);
	public java.util.Collection<org.emftext.language.refactoring.specification.resource.util.RefspecPair<org.emftext.language.refactoring.specification.resource.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers();
}
