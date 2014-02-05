/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class OperatorsResourceFactory implements Resource.Factory {
	
	public OperatorsResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsResource(uri);
	}
	
}
