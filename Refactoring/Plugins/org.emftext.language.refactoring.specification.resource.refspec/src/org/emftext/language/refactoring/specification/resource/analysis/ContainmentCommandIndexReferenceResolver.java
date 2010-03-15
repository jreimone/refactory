/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

public class ContainmentCommandIndexReferenceResolver implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.ContainmentCommand, org.emftext.language.refactoring.refactoring_specification.IndexVariable> {
	
	private org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.ContainmentCommand, org.emftext.language.refactoring.refactoring_specification.IndexVariable> delegate = new org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.ContainmentCommand, org.emftext.language.refactoring.refactoring_specification.IndexVariable>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.refactoring_specification.ContainmentCommand container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<org.emftext.language.refactoring.refactoring_specification.IndexVariable> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.refactoring_specification.IndexVariable element, org.emftext.language.refactoring.refactoring_specification.ContainmentCommand container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
