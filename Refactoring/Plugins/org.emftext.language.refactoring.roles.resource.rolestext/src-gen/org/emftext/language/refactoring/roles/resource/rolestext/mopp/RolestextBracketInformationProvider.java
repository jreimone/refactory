/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextBracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBracketPair> result = new java.util.ArrayList<org.emftext.language.refactoring.roles.resource.rolestext.IRolestextBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("[", "]", true));
		return result;
	}
	
}
