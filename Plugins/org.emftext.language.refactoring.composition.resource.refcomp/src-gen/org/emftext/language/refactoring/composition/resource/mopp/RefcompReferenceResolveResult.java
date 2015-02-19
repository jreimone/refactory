/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveRe
 * sult interface that collects mappings in a list.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class RefcompReferenceResolveResult<ReferenceType> implements org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult<ReferenceType> {
	
	private Collection<org.emftext.language.refactoring.composition.resource.IRefcompReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix> quickFixes;
	
	public RefcompReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.emftext.language.refactoring.composition.resource.IRefcompQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.emftext.language.refactoring.composition.resource.IRefcompQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<org.emftext.language.refactoring.composition.resource.IRefcompReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new ArrayList<org.emftext.language.refactoring.composition.resource.IRefcompReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.language.refactoring.composition.resource.mopp.RefcompElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<org.emftext.language.refactoring.composition.resource.IRefcompReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.language.refactoring.composition.resource.mopp.RefcompURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
