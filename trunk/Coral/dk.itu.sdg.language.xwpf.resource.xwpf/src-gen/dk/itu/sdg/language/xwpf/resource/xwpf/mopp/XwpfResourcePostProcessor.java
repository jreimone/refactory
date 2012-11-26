/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfResourcePostProcessor implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfResourcePostProcessor {
	
	public void process(dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource resource) {
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
