/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class RefcompContainment extends org.emftext.language.refactoring.composition.resource.grammar.RefcompTerminal {
	
	private final EClass[] allowedTypes;
	
	public RefcompContainment(EStructuralFeature feature, org.emftext.language.refactoring.composition.resource.grammar.RefcompCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.language.refactoring.composition.resource.util.RefcompStringUtil.explode(allowedTypes, ", ", new org.emftext.language.refactoring.composition.resource.IRefcompFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
