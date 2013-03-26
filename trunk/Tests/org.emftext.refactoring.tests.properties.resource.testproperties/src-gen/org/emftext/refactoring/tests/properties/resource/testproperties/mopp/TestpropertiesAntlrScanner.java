/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

public class TestpropertiesAntlrScanner implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public TestpropertiesAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken result = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
