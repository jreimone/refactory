/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

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
public class TestpropertiesDelegatingResolveResult<ReferenceType> implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<ReferenceType> {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<ReferenceType> delegate;
	
	public TestpropertiesDelegatingResolveResult(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<ReferenceType> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<ReferenceType>> getMappings() {
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
	
	public Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
