/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IRefcompResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.language.refactoring.composition.resource.IRefcompResourcePostProcessor getResourcePostProcessor();
	
}
