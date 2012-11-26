/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IXwpfCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
