/**
 * Copyright 2012 
 * Rolf-Helge Pfeiffer (IT University Copenhagen)
 * Jan Reimann (TU Dresden, Software Technology Group)
 * Mirko Seifert (DevBoost GmbH)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * A FuzzyResolveResult is an implementation of the IXwpfReferenceResolveResult
 * interface that delegates all method calls to a given
 * IXwpfReferenceResolveResult with ReferenceType EObject. It is used by reference
 * resolver switches to collect results from different reference resolvers in a
 * type safe manner.
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class XwpfFuzzyResolveResult<ReferenceType extends org.eclipse.emf.ecore.EObject> implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult<ReferenceType> {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate;
	
	public XwpfFuzzyResolveResult(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult<org.eclipse.emf.ecore.EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceMapping<ReferenceType>> getMappings() {
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
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (org.eclipse.emf.ecore.EObject) target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
