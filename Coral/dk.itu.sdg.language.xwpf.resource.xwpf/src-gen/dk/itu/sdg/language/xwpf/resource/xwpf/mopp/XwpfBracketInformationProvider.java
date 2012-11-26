/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfBracketInformationProvider {
	
	public class BracketPair implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBracketPair {
		
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
	
	public java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBracketPair> getBracketPairs() {
		java.util.Collection<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBracketPair> result = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
