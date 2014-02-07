/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * A FuzzyResolveResult is an implementation of the ICoedReferenceResolveResult
 * interface that delegates all method calls to a given
 * ICoedReferenceResolveResult with ReferenceType EObject. It is used by reference
 * resolver switches to collect results from different reference resolvers in a
 * type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class CoedFuzzyResolveResult<ReferenceType extends EObject> implements org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<ReferenceType> {
	
	private org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<EObject> delegate;
	
	public CoedFuzzyResolveResult(org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceMapping<ReferenceType>> getMappings() {
		return null;
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, (EObject) target);
	}
	
	public void addMapping(String identifier, URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (EObject) target, warning);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
