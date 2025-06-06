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
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver;

public class ConcreteMappingMetaclassReferenceResolver implements IRolemappingReferenceResolver<ConcreteMapping, EClass> {

	//	private static final String PACKAGE_SEPARATOR = ".";
	//	private static final String PACKAGE_SEPARATOR_REGEX = "\\.";

	public void resolve(java.lang.String identifier, ConcreteMapping concreteMapping, EReference reference, int position, boolean resolveFuzzy, final IRolemappingReferenceResolveResult<EClass> result) {
		EObject parent = EcoreUtil.getRootContainer(concreteMapping, true);
		if (parent instanceof RoleMappingModel) {
			RoleMappingModel mappingModel = (RoleMappingModel) parent;
			EPackage targetMetamodel = mappingModel.getTargetMetamodel();
			List<EPackage> validMetamodels = new LinkedList<EPackage>();
			List<EPackage> packagesOfMetaclass = concreteMapping.getPackagesOfMetaclass();
			if(packagesOfMetaclass.isEmpty()){
				validMetamodels.add(targetMetamodel);
				List<EPackage> imports = mappingModel.getImports();
				if(!imports.isEmpty()){
					validMetamodels.addAll(imports);
				}
			} else {
				validMetamodels.add(packagesOfMetaclass.get(packagesOfMetaclass.size() - 1));
			}
			Map<String, List<EClass>> eClassMap = getEClassesFromEPackages(validMetamodels);
			if (!eClassMap.isEmpty()) {
				if (resolveFuzzy) {
					for (String key : eClassMap.keySet()) {
						List<EClass> foundClasses = eClassMap.get(key);
						for (EClass eClass : foundClasses) {
							result.addMapping(key, eClass);
						}
					}
					return;
				}
				List<EClass> hopefullySingleElementList = eClassMap.get(identifier);
				if (hopefullySingleElementList == null) {
					result.setErrorMessage("Metaclass '" + identifier + "' could not be found");
				} else {
					if (hopefullySingleElementList.size() == 1) {
						result.addMapping(identifier, hopefullySingleElementList.get(0));
					} else {
						StringBuffer message = new StringBuffer("Metaclass ");
						message.append(identifier + " is not unique.\n");
						message.append(hopefullySingleElementList.size()
								+ " metaclasses have the same name in the target and the imported metamodels.\n"
								+ "Use package navigation with dot notation to uniquely identify the desired metaclass");
						result.setErrorMessage(message.toString());
					}

				}
			} else {
				result.setErrorMessage("No appropriate metaclasses exist for '" + identifier + "'");
			}
		} else {
			assert false;
		}
	}

	/**
	 * Returns a map of all EClasses that can be found in the given EPackage.
	 * The keys of the map are the names of the classes. EClasses found in sub
	 * packages are prefixed with the name of the sub package.
	 *
	 * @param packages
	 *            the package to search in
	 * @return
	 */
	private Map<String, List<EClass>> getEClassesFromEPackages(List<EPackage> packages) {
		Map<String, List<EClass>> foundEClasses = new LinkedHashMap<String, List<EClass>>();
		for (EPackage metamodel : packages) {
			List<EClassifier> eClassifiers = metamodel.getEClassifiers();
			for (EClassifier eClassifier : eClassifiers) {
				if (eClassifier instanceof EClass) {
					List<EClass> classesWithSameNames = foundEClasses.get(eClassifier.getName());
					if (classesWithSameNames == null) {
						classesWithSameNames = new LinkedList<EClass>();
						String name = eClassifier.getName();
						foundEClasses.put(name, classesWithSameNames);
					}
					classesWithSameNames.add((EClass) eClassifier);
				}
			}
		}
		return foundEClasses;
	}

	public java.lang.String deResolve(EClass element, ConcreteMapping container, EReference reference) {
		return element.getName();
	}

	public void setOptions(java.util.Map<?, ?> options) {
	}
}
