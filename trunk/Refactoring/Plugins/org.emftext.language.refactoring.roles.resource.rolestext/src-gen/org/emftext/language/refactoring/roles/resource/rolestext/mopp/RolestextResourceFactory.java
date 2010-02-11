/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public RolestextResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource(uri);
	}
}
