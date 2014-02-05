/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;


/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IOperatorsCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
