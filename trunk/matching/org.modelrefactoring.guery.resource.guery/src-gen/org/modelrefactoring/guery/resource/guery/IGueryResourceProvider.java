/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IGueryResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public org.modelrefactoring.guery.resource.guery.IGueryTextResource getResource();
	
}
