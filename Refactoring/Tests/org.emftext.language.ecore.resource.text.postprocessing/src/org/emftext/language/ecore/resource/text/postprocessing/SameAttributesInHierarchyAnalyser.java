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
package org.emftext.language.ecore.resource.text.postprocessing;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.ecore.resource.text.ITextEcoreQuickFix;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResource;
import org.emftext.language.ecore.resource.text.quickfixes.RefactoringQuickFix;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.mappings.ecore.facade.EcoreRefactoringFacade;

public class SameAttributesInHierarchyAnalyser extends AbstractPostProcessor {

	private static final String REFACTOR_EXTRACT_SUPER_CLASS = "Refactor: Extract SuperClass from common attributes";

	private Map<String, Map<EClassifier, List<EClass>>> attributeTypeMap = new LinkedHashMap<String, Map<EClassifier, List<EClass>>>();

	@Override
	public void analyse(TextEcoreResource resource, EPackage epackage) {
		fillMap(epackage);
		for (String name : attributeTypeMap.keySet()) {
			Map<EClassifier, List<EClass>> typeClassMap = attributeTypeMap.get(name);
			for (EClassifier type : typeClassMap.keySet()) {
				List<EClass> sameAttributeClasses = typeClassMap.get(type);
				if (sameAttributeClasses.size() > 1) {
					List<EObject> attributesToPullUp = new LinkedList<EObject>();
					for (EClass eClass : sameAttributeClasses) {
						List<EAttribute> ownAttributes = eClass.getEAttributes();
						for (EAttribute eAttribute : ownAttributes) {
							if (eAttribute.getName().equals(name) && eAttribute.getEType().equals(
									type)) {
								attributesToPullUp.add(eAttribute);
							}
						}
					}
					for (EClass eClass : sameAttributeClasses) {
						List<EClass> sameAttributeClassesCopy = new LinkedList<EClass>(sameAttributeClasses);
						sameAttributeClassesCopy.remove(eClass);
						String message = "This class and the classes \n";
						for (EClass eClass2 : sameAttributeClassesCopy) {
							message += "'" + eClass2.getName() + "', ";
						}
						message = String.copyValueOf(message.toCharArray(), 0,
								message.length() - 2);
						message += "\nall have the same attribute '" + name + "' of type '" + type.getName() + "'." +
								"\nYou should consider to invoke a refactoring.";

						//// quickfix addition
						EcoreRefactoringFacade facade = new EcoreRefactoringFacade(resource, attributesToPullUp);
						IRefactorer refactorer = facade.getRefactorer();
						RoleMapping roleMapping = facade.getExtractSuperClassMapping();
						URL iconBundlePath = facade.getExtractSuperClassIcon();
						if (refactorer != null) {
							ITextEcoreQuickFix quickfix =
									new RefactoringQuickFix(REFACTOR_EXTRACT_SUPER_CLASS, roleMapping, attributesToPullUp, refactorer, (iconBundlePath != null) ? iconBundlePath.toString()
											: null);
							addProblem(
									resource,
									ETextEcoreProblemType.SAME_ATTRIBUTES_IN_HIERARCHY,
									message, eClass, quickfix);
						} else {
							addProblem(
									resource,
									ETextEcoreProblemType.SAME_ATTRIBUTES_IN_HIERARCHY,
									message, eClass);
						}
					}
				}
			}
		}
	}

	private void fillMap(EPackage epackage) {
		List<EClassifier> classifiers = epackage.getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			if (eClassifier instanceof EClass) {
				EClass eclass = (EClass) eClassifier;
				List<EAttribute> attributes = eclass.getEAttributes();
				for (EAttribute attribute : attributes) {
					EClassifier type = attribute.getEType();
					String name = attribute.getName();
					Map<EClassifier, List<EClass>> typeClassMap = attributeTypeMap.get(name);
					if (typeClassMap == null) {
						typeClassMap = new LinkedHashMap<EClassifier, List<EClass>>();
						attributeTypeMap.put(name, typeClassMap);
					}
					List<EClass> classes = typeClassMap.get(type);
					if (classes == null) {
						classes = new LinkedList<EClass>();
						typeClassMap.put(type, classes);
					}
					classes.add(eclass);
				}
			}
		}
	}

	public void terminate() {
		// TODO Auto-generated method stub
		
	}

}
