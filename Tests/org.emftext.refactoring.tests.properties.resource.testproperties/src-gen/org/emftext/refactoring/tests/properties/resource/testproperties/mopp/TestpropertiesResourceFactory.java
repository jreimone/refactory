/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

public class TestpropertiesResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public TestpropertiesResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource(uri);
	}
	
}
