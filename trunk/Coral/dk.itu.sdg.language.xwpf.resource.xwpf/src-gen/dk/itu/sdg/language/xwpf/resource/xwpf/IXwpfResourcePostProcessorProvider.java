/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IXwpfResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfResourcePostProcessor getResourcePostProcessor();
	
}
