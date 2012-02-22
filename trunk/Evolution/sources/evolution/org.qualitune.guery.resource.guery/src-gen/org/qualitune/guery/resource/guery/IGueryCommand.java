/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IGueryCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
