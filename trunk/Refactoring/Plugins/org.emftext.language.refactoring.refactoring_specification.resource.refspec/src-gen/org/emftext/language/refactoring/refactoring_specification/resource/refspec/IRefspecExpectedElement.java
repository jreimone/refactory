/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec;

// An element that is expected at a given position in a resource
// stream.
public interface IRefspecExpectedElement {
	
	public java.lang.String getTokenName();
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	public void addFollower(org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path);
	public java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.util.RefspecPair<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers();
}
