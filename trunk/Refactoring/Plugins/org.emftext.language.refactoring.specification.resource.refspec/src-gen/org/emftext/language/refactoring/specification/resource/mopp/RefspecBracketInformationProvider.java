/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecBracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.refactoring.specification.resource.IRefspecBracketPair {
		
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
	
	public java.util.Collection<org.emftext.language.refactoring.specification.resource.IRefspecBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.refactoring.specification.resource.IRefspecBracketPair> result = new java.util.ArrayList<org.emftext.language.refactoring.specification.resource.IRefspecBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("<", ">", false));
		return result;
	}
	
}
