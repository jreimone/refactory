/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.roles.resource.rolestext.mopp;
public class RolestextTextToken implements org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextToken {
	
	private final org.emftext.language.refactoring.roles.resource.rolestext.IRolestextMetaInformation metaInformation = new org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextMetaInformation();
	private final org.antlr.runtime3_2_0.Token antlrToken;
	
	public RolestextTextToken(org.antlr.runtime3_2_0.Token antlrToken) {
		super();
		this.antlrToken = antlrToken;
	}
	
	public java.lang.String getName() {
		return getTokenName(metaInformation.getTokenNames(), antlrToken.getType());
	}
	
	public int getOffset() {
		return ((org.antlr.runtime3_2_0.CommonToken) antlrToken).getStartIndex();
	}
	
	public int getLength() {
		return ((org.antlr.runtime3_2_0.CommonToken) antlrToken).getStopIndex() - ((org.antlr.runtime3_2_0.CommonToken) antlrToken).getStartIndex() + 1;
	}
	
	public boolean canBeUsedForSyntaxHighlighting() {
		int tokenType = antlrToken.getType();
		if (tokenType == org.antlr.runtime3_2_0.Token.EOF) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.UP) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.DOWN) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}
	
	public java.lang.String getText() {
		return antlrToken.getText();
	}
	
	public java.lang.String getTokenName(java.lang.String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		java.lang.String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
	
}
