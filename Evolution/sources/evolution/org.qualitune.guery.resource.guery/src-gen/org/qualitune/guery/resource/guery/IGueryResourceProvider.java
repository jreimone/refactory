/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IGueryResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public org.qualitune.guery.resource.guery.IGueryTextResource getResource();
	
}
