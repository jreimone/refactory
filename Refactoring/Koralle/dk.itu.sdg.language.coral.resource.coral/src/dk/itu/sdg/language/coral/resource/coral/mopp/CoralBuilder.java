/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.coral.resource.coral.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;

import dk.itu.sdg.language.coral.resource.coral.ICoralBuilder;

public class CoralBuilder implements ICoralBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	
	
	
	public IStatus build(CoralResource resource, IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		
		System.out.println("OIOIOIOIOI");
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
}
