/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public RefspecResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecResource(uri);
	}
}
