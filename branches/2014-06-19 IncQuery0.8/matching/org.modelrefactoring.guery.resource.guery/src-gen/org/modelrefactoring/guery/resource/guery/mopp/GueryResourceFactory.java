/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public GueryResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.modelrefactoring.guery.resource.guery.mopp.GueryResource(uri);
	}
	
}
