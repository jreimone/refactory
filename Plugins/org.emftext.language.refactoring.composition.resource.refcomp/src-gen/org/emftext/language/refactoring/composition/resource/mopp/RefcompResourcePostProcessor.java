/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;


public class RefcompResourcePostProcessor implements org.emftext.language.refactoring.composition.resource.IRefcompResourcePostProcessor {
	
	public void process(org.emftext.language.refactoring.composition.resource.mopp.RefcompResource resource) {
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
