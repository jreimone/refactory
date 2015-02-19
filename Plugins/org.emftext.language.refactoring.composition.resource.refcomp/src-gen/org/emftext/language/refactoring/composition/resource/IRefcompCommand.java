/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IRefcompCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
