/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IXwpfResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource getResource();
	
}
