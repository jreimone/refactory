/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface ICoedResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource getResource();
	
}
