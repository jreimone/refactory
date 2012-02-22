/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class GueryExpectedCsString extends org.qualitune.guery.resource.guery.mopp.GueryAbstractExpectedElement {
	
	private org.qualitune.guery.resource.guery.grammar.GueryKeyword keyword;
	
	public GueryExpectedCsString(org.qualitune.guery.resource.guery.grammar.GueryKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.qualitune.guery.resource.guery.grammar.GuerySyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof GueryExpectedCsString) {
			return getValue().equals(((GueryExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
