/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

public abstract class RefspecANTLRParserBase extends org.antlr.runtime3_2_0.Parser implements org.emftext.language.refactoring.specification.resource.IRefspecTextParser {
	
	public RefspecANTLRParserBase(org.antlr.runtime3_2_0.TokenStream input) {
		super(input);
	}
	
	public RefspecANTLRParserBase(org.antlr.runtime3_2_0.TokenStream input, org.antlr.runtime3_2_0.RecognizerSharedState state) {
		super(input, state);
	}
	
}
