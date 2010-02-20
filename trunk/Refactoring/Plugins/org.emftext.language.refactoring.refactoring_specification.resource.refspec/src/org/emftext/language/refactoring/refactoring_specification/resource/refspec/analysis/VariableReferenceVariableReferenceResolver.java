/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis;

public class VariableReferenceVariableReferenceResolver implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.VariableReference, org.emftext.language.refactoring.refactoring_specification.Variable> {
	
	private org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.VariableReference, org.emftext.language.refactoring.refactoring_specification.Variable> delegate = new org.emftext.language.refactoring.refactoring_specification.resource.refspec.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.VariableReference, org.emftext.language.refactoring.refactoring_specification.Variable>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.refactoring_specification.VariableReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolveResult<org.emftext.language.refactoring.refactoring_specification.Variable> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.refactoring_specification.Variable element, org.emftext.language.refactoring.refactoring_specification.VariableReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
