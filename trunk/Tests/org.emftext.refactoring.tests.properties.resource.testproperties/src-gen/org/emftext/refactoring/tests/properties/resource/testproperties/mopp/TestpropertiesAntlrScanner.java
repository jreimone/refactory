/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class TestpropertiesAntlrScanner implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextScanner {
	
	private Lexer antlrLexer;
	
	public TestpropertiesAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesTextToken result = new org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
