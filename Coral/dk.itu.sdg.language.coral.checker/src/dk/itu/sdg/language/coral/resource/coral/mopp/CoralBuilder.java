/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.coral.resource.coral.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

import dk.itu.sdg.language.coral.generators.CollectorGenerator;
import dk.itu.sdg.language.coral.generators.ConstraintGenerator;
import dk.itu.sdg.language.coral.resource.coral.ICoralBuilder;

public class CoralBuilder implements ICoralBuilder {
	
	//TODO: this is not needed! delete it!!!
	
	public boolean isBuildingNeeded(URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	
	
	
	public IStatus build(CoralResource resource, IProgressMonitor monitor) {		
		
		//TODO: put this into a job
		System.out.println("Generating Groovy Files...");
		
		if (!resource.getErrors().isEmpty()) {
//			return Status.CANCEL_STATUS;
		}
		
		CollectorGenerator collectorGenerator = new CollectorGenerator(resource);
		collectorGenerator.generate();
		ConstraintGenerator constraintGenerator = new ConstraintGenerator(resource);
		constraintGenerator.generate();
		
		return Status.OK_STATUS;
	}



	@Override
	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
