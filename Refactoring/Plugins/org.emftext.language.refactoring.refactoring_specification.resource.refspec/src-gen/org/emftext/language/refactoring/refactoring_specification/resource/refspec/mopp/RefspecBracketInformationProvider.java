/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.refactoring_specification.resource.refspec.mopp;

public class RefspecBracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecBracketPair {
		
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
	
	public java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecBracketPair> result = new java.util.ArrayList<org.emftext.language.refactoring.refactoring_specification.resource.refspec.IRefspecBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		return result;
	}
	
}
