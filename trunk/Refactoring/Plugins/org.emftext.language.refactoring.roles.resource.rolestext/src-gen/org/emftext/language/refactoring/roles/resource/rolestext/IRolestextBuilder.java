/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext;

public interface IRolestextBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
