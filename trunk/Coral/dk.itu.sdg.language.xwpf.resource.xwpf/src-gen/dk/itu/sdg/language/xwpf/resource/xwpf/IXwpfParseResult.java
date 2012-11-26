/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IXwpfParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfCommand<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource>> getPostParseCommands();
	
}
