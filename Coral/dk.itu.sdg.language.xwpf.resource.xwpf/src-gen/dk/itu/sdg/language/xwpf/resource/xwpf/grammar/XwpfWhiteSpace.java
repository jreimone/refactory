/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.grammar;

public class XwpfWhiteSpace extends dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfFormattingElement {
	
	private final int amount;
	
	public XwpfWhiteSpace(int amount, dk.itu.sdg.language.xwpf.resource.xwpf.grammar.XwpfCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
