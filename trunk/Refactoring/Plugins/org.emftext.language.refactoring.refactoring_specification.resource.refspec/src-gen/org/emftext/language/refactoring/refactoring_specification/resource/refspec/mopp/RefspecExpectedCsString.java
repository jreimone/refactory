/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

// A representation for a range in a document where a keyword (i.e.,
// a static string) is expected.
public class RefspecExpectedCsString extends org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp.RefspecAbstractExpectedElement {
	
	private String value;
	
	public RefspecExpectedCsString(org.eclipse.emf.ecore.EClass ruleMetaclass, java.lang.String value) {
		super(ruleMetaclass);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getTokenName() {
		return "'" + value + "'";
	}
	
	public String toString() {
		return "CsString \"" + value + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof RefspecExpectedCsString) {
			return this.value.equals(((RefspecExpectedCsString) o).value);
		}
		return false;
	}
	
}
