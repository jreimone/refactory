/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class TestpropertiesExpectedStructuralFeature extends org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesAbstractExpectedElement {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder placeholder;
	
	public TestpropertiesExpectedStructuralFeature(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof TestpropertiesExpectedStructuralFeature) {
			return getFeature().equals(((TestpropertiesExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
