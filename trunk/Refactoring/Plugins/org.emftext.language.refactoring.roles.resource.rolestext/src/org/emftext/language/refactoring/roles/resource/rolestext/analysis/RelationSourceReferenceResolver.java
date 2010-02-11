/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.analysis;

public class RelationSourceReferenceResolver implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolver<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role> {
	
	private org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultResolverDelegate<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role> delegate = new org.emftext.language.refactoring.roles.resource.rolestext.analysis.RolestextDefaultResolverDelegate<org.emftext.language.refactoring.roles.Relation, org.emftext.language.refactoring.roles.Role>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.roles.Relation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.roles.resource.rolestext.IRolestextReferenceResolveResult<org.emftext.language.refactoring.roles.Role> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.Role element, org.emftext.language.refactoring.roles.Relation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
