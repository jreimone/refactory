/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class CoedExpectedCsString extends org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedAbstractExpectedElement {
	
	private org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword keyword;
	
	public CoedExpectedCsString(org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof CoedExpectedCsString) {
			return getValue().equals(((CoedExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
