/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.analysis;

public class ConnectionToReferenceResolver implements org.modelrefactoring.guery.resource.guery.IGueryReferenceResolver<org.modelrefactoring.guery.Connection, org.modelrefactoring.guery.Role> {
	
	private org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultResolverDelegate<org.modelrefactoring.guery.Connection, org.modelrefactoring.guery.Role> delegate = new org.modelrefactoring.guery.resource.guery.analysis.GueryDefaultResolverDelegate<org.modelrefactoring.guery.Connection, org.modelrefactoring.guery.Role>();
	
	public void resolve(String identifier, org.modelrefactoring.guery.Connection container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.modelrefactoring.guery.resource.guery.IGueryReferenceResolveResult<org.modelrefactoring.guery.Role> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.modelrefactoring.guery.Role element, org.modelrefactoring.guery.Connection container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
