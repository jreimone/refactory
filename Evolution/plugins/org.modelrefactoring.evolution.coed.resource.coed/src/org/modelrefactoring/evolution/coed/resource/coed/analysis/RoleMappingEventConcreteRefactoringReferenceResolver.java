/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.analysis;

import org.eclipse.emf.ecore.EReference;

public class RoleMappingEventConcreteRefactoringReferenceResolver implements org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolver<org.modelrefactoring.evolution.coed.RoleMappingEvent, org.emftext.language.refactoring.rolemapping.RoleMapping> {
	
	private org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultResolverDelegate<org.modelrefactoring.evolution.coed.RoleMappingEvent, org.emftext.language.refactoring.rolemapping.RoleMapping> delegate = new org.modelrefactoring.evolution.coed.resource.coed.analysis.CoedDefaultResolverDelegate<org.modelrefactoring.evolution.coed.RoleMappingEvent, org.emftext.language.refactoring.rolemapping.RoleMapping>();
	
	public void resolve(String identifier, org.modelrefactoring.evolution.coed.RoleMappingEvent container, EReference reference, int position, boolean resolveFuzzy, final org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<org.emftext.language.refactoring.rolemapping.RoleMapping> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.emftext.language.refactoring.rolemapping.RoleMapping element, org.modelrefactoring.evolution.coed.RoleMappingEvent container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
