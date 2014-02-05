/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.mopp;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class OperatorsExpectedStructuralFeature extends org.modelrefactoring.evolution.operators.resource.operators.mopp.OperatorsAbstractExpectedElement {
	
	private org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder placeholder;
	
	public OperatorsExpectedStructuralFeature(org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public Set<String> getTokenNames() {
		return Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof OperatorsExpectedStructuralFeature) {
			return getFeature().equals(((OperatorsExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
