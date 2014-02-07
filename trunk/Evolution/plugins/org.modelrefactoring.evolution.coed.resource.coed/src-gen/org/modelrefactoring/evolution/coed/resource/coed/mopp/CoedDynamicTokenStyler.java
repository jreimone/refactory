/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;


public class CoedDynamicTokenStyler {
	
	/**
	 * The offset in the text where the lexer started.
	 */
	private int offset;
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenStyle getDynamicTokenStyle(org.modelrefactoring.evolution.coed.resource.coed.ICoedTextResource resource, org.modelrefactoring.evolution.coed.resource.coed.ICoedTextToken token, org.modelrefactoring.evolution.coed.resource.coed.ICoedTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
