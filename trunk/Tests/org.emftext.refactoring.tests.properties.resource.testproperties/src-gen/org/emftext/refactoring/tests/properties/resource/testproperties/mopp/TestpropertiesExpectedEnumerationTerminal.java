/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class TestpropertiesExpectedEnumerationTerminal extends org.emftext.refactoring.tests.properties.resource.testproperties.mopp.TestpropertiesAbstractExpectedElement {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesEnumerationTerminal enumerationTerminal;
	
	public TestpropertiesExpectedEnumerationTerminal(org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
	
	/**
	 * Returns the expected enumeration terminal.
	 */
	public org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesSyntaxElement getSymtaxElement() {
		return enumerationTerminal;
	}
	
	public String toString() {
		return "EnumTerminal \"" + getEnumerationTerminal() + "\"";
	}
	
}
