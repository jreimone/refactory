/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IPropertiesResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesResourcePostProcessor getResourcePostProcessor();
	
}
