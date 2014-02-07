/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class CoedAntlrScanner implements org.modelrefactoring.evolution.coed.resource.coed.ICoedTextScanner {
	
	private Lexer antlrLexer;
	
	public CoedAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.modelrefactoring.evolution.coed.resource.coed.ICoedTextToken result = new org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
