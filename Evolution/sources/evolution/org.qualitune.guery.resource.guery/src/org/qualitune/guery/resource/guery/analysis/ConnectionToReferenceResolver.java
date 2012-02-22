/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.analysis;

public class ConnectionToReferenceResolver implements org.qualitune.guery.resource.guery.IGueryReferenceResolver<org.qualitune.guery.Connection, org.qualitune.guery.Role> {
	
	private org.qualitune.guery.resource.guery.analysis.GueryDefaultResolverDelegate<org.qualitune.guery.Connection, org.qualitune.guery.Role> delegate = new org.qualitune.guery.resource.guery.analysis.GueryDefaultResolverDelegate<org.qualitune.guery.Connection, org.qualitune.guery.Role>();
	
	public void resolve(String identifier, org.qualitune.guery.Connection container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.qualitune.guery.resource.guery.IGueryReferenceResolveResult<org.qualitune.guery.Role> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.qualitune.guery.Role element, org.qualitune.guery.Connection container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
