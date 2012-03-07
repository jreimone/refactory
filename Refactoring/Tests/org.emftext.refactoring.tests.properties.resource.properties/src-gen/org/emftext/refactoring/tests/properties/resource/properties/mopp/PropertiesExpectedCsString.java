/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class PropertiesExpectedCsString extends org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesAbstractExpectedElement {
	
	private org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword keyword;
	
	public PropertiesExpectedCsString(org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof PropertiesExpectedCsString) {
			return getValue().equals(((PropertiesExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
