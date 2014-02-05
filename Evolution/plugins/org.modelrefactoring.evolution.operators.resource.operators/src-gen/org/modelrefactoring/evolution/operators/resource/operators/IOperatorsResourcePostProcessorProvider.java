/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;


/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IOperatorsResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsResourcePostProcessor getResourcePostProcessor();
	
}
