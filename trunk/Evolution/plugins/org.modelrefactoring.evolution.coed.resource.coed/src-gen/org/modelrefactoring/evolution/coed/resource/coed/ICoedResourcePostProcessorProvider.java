/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface ICoedResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedResourcePostProcessor getResourcePostProcessor();
	
}
