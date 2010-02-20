/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec;

public interface IRefspecBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
