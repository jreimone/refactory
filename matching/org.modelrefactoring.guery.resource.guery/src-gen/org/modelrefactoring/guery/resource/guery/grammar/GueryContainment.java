/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.guery.resource.guery.grammar;

public class GueryContainment extends org.modelrefactoring.guery.resource.guery.grammar.GueryTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public GueryContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.modelrefactoring.guery.resource.guery.grammar.GueryCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.modelrefactoring.guery.resource.guery.util.GueryStringUtil.explode(allowedTypes, ", ", new org.modelrefactoring.guery.resource.guery.IGueryFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
