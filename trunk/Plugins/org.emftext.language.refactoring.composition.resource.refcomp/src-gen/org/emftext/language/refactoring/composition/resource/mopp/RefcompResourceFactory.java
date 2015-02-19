/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class RefcompResourceFactory implements Resource.Factory {
	
	public RefcompResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new org.emftext.language.refactoring.composition.resource.mopp.RefcompResource(uri);
	}
	
}
