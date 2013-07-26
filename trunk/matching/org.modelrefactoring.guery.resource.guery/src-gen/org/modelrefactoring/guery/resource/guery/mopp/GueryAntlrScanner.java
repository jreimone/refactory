/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.mopp;

public class GueryAntlrScanner implements org.modelrefactoring.guery.resource.guery.IGueryTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public GueryAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.modelrefactoring.guery.resource.guery.IGueryTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.modelrefactoring.guery.resource.guery.IGueryTextToken result = new org.modelrefactoring.guery.resource.guery.mopp.GueryANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
