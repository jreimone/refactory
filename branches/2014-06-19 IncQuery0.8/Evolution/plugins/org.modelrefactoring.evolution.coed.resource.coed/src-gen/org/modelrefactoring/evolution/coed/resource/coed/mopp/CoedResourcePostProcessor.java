/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;


public class CoedResourcePostProcessor implements org.modelrefactoring.evolution.coed.resource.coed.ICoedResourcePostProcessor {
	
	public void process(org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}
