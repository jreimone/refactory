/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties;

public interface IPropertiesHoverTextProvider {
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object);
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject);
}
