/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesAntlrScanner implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextScanner {
	
	private org.antlr.runtime3_2_0.Lexer antlrLexer;
	
	public PropertiesAntlrScanner(org.antlr.runtime3_2_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_2_0.Token current = antlrLexer.nextToken();
		org.emftext.refactoring.tests.properties.resource.properties.IPropertiesTextToken result = new org.emftext.refactoring.tests.properties.resource.properties.mopp.PropertiesTextToken(current);
		return result;
	}
	
	public void setText(java.lang.String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_2_0.ANTLRStringStream(text));
	}
	
}
