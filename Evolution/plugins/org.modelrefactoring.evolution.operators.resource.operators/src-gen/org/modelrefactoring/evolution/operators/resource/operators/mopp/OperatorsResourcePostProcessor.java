/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;


public class OperatorsResourcePostProcessor implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsResourcePostProcessor {
	
	public void process(org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResource resource) {
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
