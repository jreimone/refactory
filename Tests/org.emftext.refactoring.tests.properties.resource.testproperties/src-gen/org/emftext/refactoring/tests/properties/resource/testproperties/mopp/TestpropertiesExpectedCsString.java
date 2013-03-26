/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class TestpropertiesExpectedCsString extends org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesAbstractExpectedElement {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesKeyword keyword;
	
	public TestpropertiesExpectedCsString(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof TestpropertiesExpectedCsString) {
			return getValue().equals(((TestpropertiesExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
