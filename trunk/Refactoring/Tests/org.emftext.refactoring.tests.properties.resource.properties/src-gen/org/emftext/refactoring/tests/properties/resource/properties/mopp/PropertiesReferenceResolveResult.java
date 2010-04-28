/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

/**
 * A basic implementation of the
 * org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenc
 * eResolveResult interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class PropertiesReferenceResolveResult<ReferenceType> implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	
	public PropertiesReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceMapping<ReferenceType>>();
		}
		mappings.add(new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
