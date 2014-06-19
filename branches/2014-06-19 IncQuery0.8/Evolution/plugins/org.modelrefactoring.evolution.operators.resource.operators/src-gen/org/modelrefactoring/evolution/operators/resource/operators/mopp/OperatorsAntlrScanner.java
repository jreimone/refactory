/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class OperatorsAntlrScanner implements org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextScanner {
	
	private Lexer antlrLexer;
	
	public OperatorsAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.modelrefactoring.evolution.operators.resource.operators.IOperatorsTextToken result = new org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
