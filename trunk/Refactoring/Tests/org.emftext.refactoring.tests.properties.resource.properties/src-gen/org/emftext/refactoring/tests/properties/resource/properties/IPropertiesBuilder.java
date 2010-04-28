/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties;

public interface IPropertiesBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
