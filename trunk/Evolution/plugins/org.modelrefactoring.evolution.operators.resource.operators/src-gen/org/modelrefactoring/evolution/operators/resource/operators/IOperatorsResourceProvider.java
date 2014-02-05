/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IOperatorsResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextResource getResource();
	
}
