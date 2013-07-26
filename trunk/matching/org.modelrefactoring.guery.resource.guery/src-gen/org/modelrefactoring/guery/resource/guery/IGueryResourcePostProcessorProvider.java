/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IGueryResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.modelrefactoring.guery.resource.guery.IGueryResourcePostProcessor getResourcePostProcessor();
	
}
