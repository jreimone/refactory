/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.qualitune.guery.resource.guery.mopp;

public class GueryBracketInformationProvider {
	
	public class BracketPair implements org.qualitune.guery.resource.guery.IGueryBracketPair {
		
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
	
	public java.util.Collection<org.qualitune.guery.resource.guery.IGueryBracketPair> getBracketPairs() {
		java.util.Collection<org.qualitune.guery.resource.guery.IGueryBracketPair> result = new java.util.ArrayList<org.qualitune.guery.resource.guery.IGueryBracketPair>();
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("[", "]", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
