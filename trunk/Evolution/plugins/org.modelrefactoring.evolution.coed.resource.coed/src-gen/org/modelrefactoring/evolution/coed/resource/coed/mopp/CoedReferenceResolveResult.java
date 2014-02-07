/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * A basic implementation of the
 * org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class CoedReferenceResolveResult<ReferenceType> implements org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceResolveResult<ReferenceType> {
	
	private Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> quickFixes;
	
	public CoedReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<org.modelrefactoring.evolution.coed.resource.coed.ICoedQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<org.modelrefactoring.evolution.coed.resource.coed.ICoedReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
