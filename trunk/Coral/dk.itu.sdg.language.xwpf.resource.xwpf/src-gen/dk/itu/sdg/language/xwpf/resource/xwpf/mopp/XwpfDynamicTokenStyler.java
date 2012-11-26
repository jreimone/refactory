/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

public class XwpfDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle getDynamicTokenStyle(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextResource resource, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTextToken token, dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
