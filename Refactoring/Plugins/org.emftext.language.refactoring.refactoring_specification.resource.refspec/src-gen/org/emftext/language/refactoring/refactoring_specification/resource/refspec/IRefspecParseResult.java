/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec;

// An interface used to access the result of parsing a
// document.
public interface IRefspecParseResult {
	
	public org.eclipse.emf.ecore.EObject getRoot();
	
	public java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecCommand<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecTextResource>> getPostParseCommands();
}
