/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public PropertiesResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource(uri);
	}
}
