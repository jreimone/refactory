/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

public class TestpropertiesResourcePostProcessor implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesResourcePostProcessor {
	
	public void process(org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesResource resource) {
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
