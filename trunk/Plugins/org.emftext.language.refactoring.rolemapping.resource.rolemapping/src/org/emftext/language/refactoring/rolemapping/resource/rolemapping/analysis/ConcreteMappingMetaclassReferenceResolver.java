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
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class ConcreteMappingMetaclassReferenceResolver
implements
org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass> {

	private static final String PACKAGE_SEPARATOR = ".";
	private static final String PACKAGE_SEPARATOR_REGEX = "\\.";

	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass>();

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EObject parent = container.eContainer().eContainer();
		if (parent instanceof RoleMappingModel) {
			RoleMappingModel mappingModel = (RoleMappingModel) parent;
			EPackage targetMetamodel = mappingModel.getTargetMetamodel();
			List<EPackage> imports = mappingModel.getImports();
			List<EPackage> validMetamodels = new LinkedList<EPackage>(imports);
			validMetamodels.add(targetMetamodel);

			if (targetMetamodel != null && !targetMetamodel.eIsProxy()) {
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
						result.setErrorMessage("Metaclass '" + identifier
								+ "' could not be found");
					} else {
						if (hopefullySingleElementList.size() == 1) {
							result.addMapping(identifier, hopefullySingleElementList.get(0));
						} else {
							StringBuffer message = new StringBuffer("Metaclass ");
							message.append(identifier + " is not unique.\n");
							message.append(hopefullySingleElementList.size()
									+ " other Metaclasses have the same name and package navigation in the target and the imported metamodels");
							result.setErrorMessage("");
						}

					}
				} else {
					String[] segments = identifier.split(PACKAGE_SEPARATOR_REGEX);
					if (segments.length == 1) {
						result.setErrorMessage("Metaclass '" + segments[0]
								+ "' doesn't exist in "
								+ targetMetamodel.getNsURI());
					} else {
						String packageString = "";
						for (int i = 0; i < segments.length - 1; i++) {
							packageString += segments[i] + PACKAGE_SEPARATOR;
						}
						StringBuilder builder = new StringBuilder(packageString);
						builder.deleteCharAt(builder.length() - 1);
						result.setErrorMessage("Metaclass '"
								+ segments[segments.length - 1]
										+ "' doesn't exist in "
										+ targetMetamodel.getNsURI() + "/"
										+ builder.toString());
					}
				}
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
						String name = "";
						EPackage superPackage = metamodel.getESuperPackage();
						if (superPackage == null) {
							name = eClassifier.getName();
						} else {
							name = getPackageNavigation((EClass) eClassifier);
						}
						foundEClasses.put(name, classesWithSameNames);
					}
					classesWithSameNames.add((EClass) eClassifier);
				}
			}
			List<EPackage> subPackages = metamodel.getESubpackages();
			Map<String, List<EClass>> subPackagesMap = getEClassesFromEPackages(subPackages);
			for (String key : subPackagesMap.keySet()) {
				List<EClass> existentClasses = foundEClasses.get(key);
				if (existentClasses != null) {
					existentClasses.addAll(subPackagesMap.get(key));
				} else {
					foundEClasses.put(key, subPackagesMap.get(key));
				}
			}
		}
		return foundEClasses;
	}

	private String getPackageNavigation(EClass eclass) {
		EPackage ePackage = eclass.getEPackage();
		StringBuffer packageNavigation = new StringBuffer();
		while (ePackage.getESuperPackage() != null) {
			packageNavigation.insert(0, ePackage.getName() + PACKAGE_SEPARATOR);
			ePackage = ePackage.getESuperPackage();
		}
		packageNavigation.append(eclass.getName());
		return packageNavigation.toString();
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
	}
}
