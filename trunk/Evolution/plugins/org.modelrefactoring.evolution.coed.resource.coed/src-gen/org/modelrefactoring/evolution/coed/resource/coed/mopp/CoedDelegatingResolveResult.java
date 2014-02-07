/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;

/**
 * An implementation of the ResolveResult interface that delegates all method
 * calls to another ResolveResult. Client may subclass this class to easily create
 * custom ResolveResults.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class CoedDelegatingResolveResult<ReferenceType> implements org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<ReferenceType> {
	
	private org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<ReferenceType> delegate;
	
	public CoedDelegatingResolveResult(org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<ReferenceType> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceMapping<ReferenceType>> getMappings() {
		return delegate.getMappings();
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
		delegate.addMapping(identifier, target);
	}
	
	public void addMapping(String identifier, URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, target, warning);
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
