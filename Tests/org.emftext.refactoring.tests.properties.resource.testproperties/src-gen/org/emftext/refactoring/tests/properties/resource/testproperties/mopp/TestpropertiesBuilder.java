/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

public class TestpropertiesBuilder implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		// change this to return true to enable building of all resources
		return false;
	}
	
	public IStatus build(org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource resource, IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		return Status.OK_STATUS;
	}
	
	/**
	 * Handles the deletion of the given resource.
	 */
	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		// by default nothing is done when a resource is deleted
		return Status.OK_STATUS;
	}
	
}
