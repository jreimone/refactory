/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A class to represent an enumeration terminal in the grammar.
 */
public class CoedEnumerationTerminal extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedTerminal {
	
	private java.util.Map<String, String> mapping = new java.util.LinkedHashMap<String, String>();
	
	public CoedEnumerationTerminal(EStructuralFeature attribute, String[] literalMappings, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof EAttribute;
		assert literalMappings.length % 2 == 0;
		for (int i = 0; i < literalMappings.length; i += 2) {
			String literalName = literalMappings[i];
			String text = literalMappings[i + 1];
			this.mapping.put(literalName, text);
		}
	}
	
	public Map<String, String> getLiteralMapping() {
		return this.mapping;
	}
	
	public EAttribute getAttribute() {
		return (EAttribute) getFeature();
	}
	
	public String getText(String literalName) {
		return this.mapping.get(literalName);
	}
	
}
