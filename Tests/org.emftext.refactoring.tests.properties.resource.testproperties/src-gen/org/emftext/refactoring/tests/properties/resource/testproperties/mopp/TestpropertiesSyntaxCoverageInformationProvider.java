/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.testproperties.mopp;

import org.eclipse.emf.ecore.EClass;

public class TestpropertiesSyntaxCoverageInformationProvider {
	
	public EClass[] getClassesWithSyntax() {
		return new EClass[] {
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getCategory(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKeyValuePair(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getKey(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getEObjectReferenceValue(),
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getStringValue(),
		};
	}
	
	public EClass[] getStartSymbols() {
		return new EClass[] {
			org.emftext.refactoring.tests.properties.PropertiesPackage.eINSTANCE.getPropertyModel(),
		};
	}
	
}
