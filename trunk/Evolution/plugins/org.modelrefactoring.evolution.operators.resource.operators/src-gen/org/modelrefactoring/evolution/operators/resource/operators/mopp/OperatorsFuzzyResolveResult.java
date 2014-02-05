/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * A FuzzyResolveResult is an implementation of the
 * IOperatorsReferenceResolveResult interface that delegates all method calls to a
 * given IOperatorsReferenceResolveResult with ReferenceType EObject. It is used
 * by reference resolver switches to collect results from different reference
 * resolvers in a type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class OperatorsFuzzyResolveResult<ReferenceType extends EObject> implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<ReferenceType> {
	
	private org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<EObject> delegate;
	
	public OperatorsFuzzyResolveResult(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult<EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceMapping<ReferenceType>> getMappings() {
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
	
	public Collection<org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(org.modelrefactoring.evolution.operators.resource.operators.IOperatorsQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
