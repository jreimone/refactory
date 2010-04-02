/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public class RefspecAntlrScanner implements org.emftext.language.refactoring.specification.resource.IRefspecTextScanner {
	
	private org.antlr.runtime3_2_0.Lexer antlrLexer;
	
	public RefspecAntlrScanner(org.antlr.runtime3_2_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.language.refactoring.specification.resource.IRefspecTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_2_0.Token current = antlrLexer.nextToken();
		org.emftext.language.refactoring.specification.resource.IRefspecTextToken result = new org.emftext.language.refactoring.specification.resource.mopp.RefspecTextToken(current);
		return result;
	}
	
	public void setText(java.lang.String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_2_0.ANTLRStringStream(text));
	}
	
}
