/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public XwpfResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfResource(uri);
	}
	
}
