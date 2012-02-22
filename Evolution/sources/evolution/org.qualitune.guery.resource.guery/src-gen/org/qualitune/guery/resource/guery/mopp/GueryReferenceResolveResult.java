/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * A basic implementation of the
 * org.qualitune.guery.resource.guery.IGueryReferenceResolveResult interface that
 * collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class GueryReferenceResolveResult<ReferenceType> implements org.qualitune.guery.resource.guery.IGueryReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.qualitune.guery.resource.guery.IGueryReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.qualitune.guery.resource.guery.IGueryQuickFix> quickFixes;
	
	public GueryReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.qualitune.guery.resource.guery.IGueryQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.qualitune.guery.resource.guery.IGueryQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.qualitune.guery.resource.guery.IGueryQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.qualitune.guery.resource.guery.IGueryQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.qualitune.guery.resource.guery.IGueryReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<org.qualitune.guery.resource.guery.IGueryReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.qualitune.guery.resource.guery.mopp.GueryElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.qualitune.guery.resource.guery.IGueryReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.qualitune.guery.resource.guery.mopp.GueryURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
