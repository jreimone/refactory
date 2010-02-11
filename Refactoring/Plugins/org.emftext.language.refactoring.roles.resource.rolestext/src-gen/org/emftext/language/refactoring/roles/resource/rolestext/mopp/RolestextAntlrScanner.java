/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;

public class RolestextAntlrScanner implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextScanner {
	
	private org.antlr.runtime3_2_0.Lexer antlrLexer;
	
	public RolestextAntlrScanner(org.antlr.runtime3_2_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_2_0.Token current = antlrLexer.nextToken();
		org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextToken result = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextTextToken(current);
		return result;
	}
	
	public void setText(java.lang.String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_2_0.ANTLRStringStream(text));
	}
	
}
