/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface ITestpropertiesCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
