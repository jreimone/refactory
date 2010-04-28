/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesBracketInformationProvider {
	
	public class BracketPair implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair {
		
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
	
	public java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair> result = new java.util.ArrayList<org.emftext.refactoring.tests.properties.resource.properties.IPropertiesBracketPair>();
		result.add(new BracketPair("[", "]", false));
		result.add(new BracketPair("<", ">", false));
		return result;
	}
	
}
