/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Collections;
import java.util.Set;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class OperatorsExpectedCsString extends org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsAbstractExpectedElement {
	
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword keyword;
	
	public OperatorsExpectedCsString(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof OperatorsExpectedCsString) {
			return getValue().equals(((OperatorsExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
