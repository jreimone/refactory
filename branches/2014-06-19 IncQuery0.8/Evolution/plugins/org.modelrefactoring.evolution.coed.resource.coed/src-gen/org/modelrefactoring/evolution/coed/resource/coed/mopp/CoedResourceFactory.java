/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class CoedResourceFactory implements Resource.Factory {
	
	public CoedResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource(uri);
	}
	
}
