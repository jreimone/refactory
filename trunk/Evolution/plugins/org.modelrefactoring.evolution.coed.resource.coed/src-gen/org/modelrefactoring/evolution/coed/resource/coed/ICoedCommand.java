/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface ICoedCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
