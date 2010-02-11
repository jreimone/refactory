/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

// A representation for a range in a document where a terminal (i.e.,
// a placeholder or a keyword) is expected.
// The range is expressed using two integers denoting the start of the range
// including hidden tokens (e.g., whitespace) and excluding those token 
// (i.e., the part of the document containing the relevant characters).
public class RolestextExpectedTerminal {
	
	private int followSetID;
	private org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement terminal;
	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private java.lang.String prefix;
	private org.eclipse.emf.ecore.EStructuralFeature[] containmentTrace;
	
	public RolestextExpectedTerminal(org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		super();
		this.terminal = terminal;
		this.followSetID = followSetID;
		this.containmentTrace = containmentTrace;
	}
	
	public int getFollowSetID() {
		return followSetID;
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextExpectedElement getTerminal() {
		return terminal;
	}
	
	public java.lang.String toString() {
		return terminal == null ? "null" : terminal.toString();
	}
	
	public boolean equals(java.lang.Object o) {
		return this.terminal.equals(((RolestextExpectedTerminal) o).terminal);
	}
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
	}
	
	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}
	
	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}
	
	public java.lang.String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(java.lang.String prefix) {
		this.prefix = prefix;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature[] getContainmentTrace() {
		return containmentTrace;
	}
	
}
