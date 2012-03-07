/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.grammar;

public class PropertiesContainment extends org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public PropertiesContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.refactoring.tests.properties.resource.properties.grammar.PropertiesCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.refactoring.tests.properties.resource.properties.util.PropertiesStringUtil.explode(allowedTypes, ", ", new org.emftext.refactoring.tests.properties.resource.properties.IPropertiesFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
