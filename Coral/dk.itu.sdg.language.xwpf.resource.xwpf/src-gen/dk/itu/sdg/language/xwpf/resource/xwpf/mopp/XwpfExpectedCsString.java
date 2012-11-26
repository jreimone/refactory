/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class XwpfExpectedCsString extends dk.itu.sdg.language.xwpf.resource.xwpf.mopp.XwpfAbstractExpectedElement {
	
	private dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfKeyword keyword;
	
	public XwpfExpectedCsString(dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof XwpfExpectedCsString) {
			return getValue().equals(((XwpfExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
