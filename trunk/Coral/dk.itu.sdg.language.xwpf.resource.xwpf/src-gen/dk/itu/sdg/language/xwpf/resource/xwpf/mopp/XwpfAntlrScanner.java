/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfAntlrScanner implements dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public XwpfAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken result = new dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
