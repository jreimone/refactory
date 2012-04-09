/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
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
