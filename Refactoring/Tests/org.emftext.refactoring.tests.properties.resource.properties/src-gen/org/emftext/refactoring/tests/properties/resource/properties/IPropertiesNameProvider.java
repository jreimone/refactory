/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties;

public interface IPropertiesNameProvider {
	
	/**
	 * Returns a list of potential identifiers that may be used to reference the given
	 * element. This method can be used to customize the identification of elements.
	 */
	public java.util.List<String> getNames(org.eclipse.emf.ecore.EObject element);
	
}
