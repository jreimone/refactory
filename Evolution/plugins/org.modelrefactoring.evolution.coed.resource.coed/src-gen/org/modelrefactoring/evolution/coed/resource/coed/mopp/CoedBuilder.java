/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

public class CoedBuilder implements org.modelrefactoring.evolution.coed.resource.coed.ICoedBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		// change this to return true to enable building of all resources
		return false;
	}
	
	public IStatus build(org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource resource, IProgressMonitor monitor) {
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
