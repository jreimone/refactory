/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.grammar;

public class TestpropertiesContainment extends org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public TestpropertiesContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.refactoring.tests.properties.resource.testproperties.grammar.TestpropertiesCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.refactoring.tests.properties.resource.testproperties.util.TestpropertiesStringUtil.explode(allowedTypes, ", ", new org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
