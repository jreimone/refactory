/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

// A representation for a range in a document where a keyword (i.e.,
// a static string) is expected.
public class RefspecExpectedCsString extends org.emftext.language.refactoring.specification.resource.mopp.RefspecAbstractExpectedElement {
	
	private org.emftext.language.refactoring.specification.resource.grammar.RefspecKeyword keyword;
	
	public RefspecExpectedCsString(org.emftext.language.refactoring.specification.resource.grammar.RefspecKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public String getTokenName() {
		return "'" + getValue() + "'";
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof RefspecExpectedCsString) {
			return getValue().equals(((RefspecExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
