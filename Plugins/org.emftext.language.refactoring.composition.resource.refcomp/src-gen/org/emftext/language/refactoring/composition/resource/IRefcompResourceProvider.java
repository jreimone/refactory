/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource;


/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IRefcompResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public org.emftext.language.refactoring.composition.resource.IRefcompTextResource getResource();
	
}
