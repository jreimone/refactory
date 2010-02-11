/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext;

// An interface used to access the result of parsing a
// document.
public interface IRolestextParseResult {
	
	public org.eclipse.emf.ecore.EObject getRoot();
	
	public java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextCommand<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource>> getPostParseCommands();
}
