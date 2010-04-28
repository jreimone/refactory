/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.mopp;

public class PropertiesSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(),
		};
	}
	
}
