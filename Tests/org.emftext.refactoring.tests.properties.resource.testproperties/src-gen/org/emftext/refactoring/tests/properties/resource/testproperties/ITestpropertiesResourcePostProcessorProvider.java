/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface ITestpropertiesResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessor getResourcePostProcessor();
	
}
