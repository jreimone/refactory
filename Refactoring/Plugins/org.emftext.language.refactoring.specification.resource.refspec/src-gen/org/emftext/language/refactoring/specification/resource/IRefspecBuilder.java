/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource;

public interface IRefspecBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.refactoring.specification.resource.mopp.RefspecResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
