/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class CoedContainment extends org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedTerminal {
	
	private final EClass[] allowedTypes;
	
	public CoedContainment(EStructuralFeature feature, org.modelrefactoring.evolution.coed.resource.coed.grammar.CoedCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.modelrefactoring.evolution.coed.resource.coed.util.CoedStringUtil.explode(allowedTypes, ", ", new org.modelrefactoring.evolution.coed.resource.coed.ICoedFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
