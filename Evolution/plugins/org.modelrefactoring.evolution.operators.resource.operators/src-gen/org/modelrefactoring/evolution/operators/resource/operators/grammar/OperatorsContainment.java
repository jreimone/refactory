/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class OperatorsContainment extends org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsTerminal {
	
	private final EClass[] allowedTypes;
	
	public OperatorsContainment(EStructuralFeature feature, org.modelrefactoring.evolution.operators.resource.operators.grammar.OperatorsCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.modelrefactoring.evolution.operators.resource.operators.util.OperatorsStringUtil.explode(allowedTypes, ", ", new org.modelrefactoring.evolution.operators.resource.operators.IOperatorsFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
