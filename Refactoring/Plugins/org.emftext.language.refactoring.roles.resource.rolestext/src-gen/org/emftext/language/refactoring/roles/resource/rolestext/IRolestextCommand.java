/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext;

// A simple interface for commands that can be executed
// and that return information about the success of their
// execution.
public interface IRolestextCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
