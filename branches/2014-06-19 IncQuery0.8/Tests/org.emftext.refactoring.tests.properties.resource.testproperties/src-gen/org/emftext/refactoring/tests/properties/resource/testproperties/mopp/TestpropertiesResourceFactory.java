/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class TestpropertiesResourceFactory implements Resource.Factory {
	
	public TestpropertiesResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource(uri);
	}
	
}
