/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext;

// An element that is expected at a given position in a resource
// stream.
public interface IRolestextExpectedElement {
	
	public java.lang.String getTokenName();
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	public void addFollower(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path);
	public java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextPair<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers();
}
