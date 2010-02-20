/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec;

// An IReferenceResolverSwitch is a object that holds references to multiple
// other reference resolvers and delegates requests to the appropriate resolver.
public interface IRefspecReferenceResolverSwitch extends org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecConfigurable {
	
	// Attempts to resolve a reference string fuzzy (returning objects that do not match exactly).
	//
	// @param identifier The identifier for the reference.
	// @param container The object that contains the reference.
	// @param reference The reference that points to the target of the reference.
	// @param result an object to store the result of the resolve operation.
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecReferenceResolveResult<org.eclipse.emf.ecore.EObject> result);
}
