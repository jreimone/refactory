/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

// A representation for a range in a document where a keyword (i.e.,
// a static string) is expected.
public class RolestextExpectedCsString extends org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextAbstractExpectedElement {
	
	private String value;
	
	public RolestextExpectedCsString(org.eclipse.emf.ecore.EClass ruleMetaclass, java.lang.String value) {
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
		if (o instanceof RolestextExpectedCsString) {
			return this.value.equals(((RolestextExpectedCsString) o).value);
		}
		return false;
	}
	
}
