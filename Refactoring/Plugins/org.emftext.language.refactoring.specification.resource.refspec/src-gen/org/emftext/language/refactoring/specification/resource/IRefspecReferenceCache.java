/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource;

public interface IRefspecReferenceCache {
	public java.lang.Object get(java.lang.String identifier);
	public void put(java.lang.String identifier, java.lang.Object target);
}
