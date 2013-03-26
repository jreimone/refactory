/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * A basic implementation of the
 * org.emftext.refactoring.tests.properties.resource.testproperties.ITestproperties
 * ReferenceResolveResult interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class TestpropertiesReferenceResolveResult<ReferenceType> implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> quickFixes;
	
	public TestpropertiesReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
