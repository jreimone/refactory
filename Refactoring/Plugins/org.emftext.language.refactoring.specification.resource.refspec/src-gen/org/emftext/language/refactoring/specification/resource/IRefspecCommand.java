/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource;

// A simple interface for commands that can be executed
// and that return information about the success of their
// execution.
public interface IRefspecCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
