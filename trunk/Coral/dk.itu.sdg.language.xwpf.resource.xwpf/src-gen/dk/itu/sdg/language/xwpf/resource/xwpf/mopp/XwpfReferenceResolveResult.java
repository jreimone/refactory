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
 * A basic implementation of the
 * dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult interface
 * that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class XwpfReferenceResolveResult<ReferenceType> implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> quickFixes;
	
	public XwpfReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
