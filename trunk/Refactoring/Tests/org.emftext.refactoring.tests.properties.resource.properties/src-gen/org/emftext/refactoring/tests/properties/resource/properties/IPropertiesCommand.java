/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IPropertiesCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
