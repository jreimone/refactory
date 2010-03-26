/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class ConcreteMappingMetaclassReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass> {

	private static final String PACKAGE_SEPARATOR = ".";
	private static final String PACKAGE_SEPARATOR_REGEX = "\\.";

	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass>();

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EObject parent = container.eContainer().eContainer();
		if (parent instanceof RoleMappingModel) {
			RoleMappingModel mappingModel = (RoleMappingModel) parent;
			EPackage targetMetamodel = mappingModel.getTargetMetamodel();
			if(targetMetamodel.eIsProxy()){
				//EcoreUtil.resolveAll(mappingModel);
			}
			if (targetMetamodel != null && !targetMetamodel.eIsProxy()) {
				String[] segments = identifier.split(PACKAGE_SEPARATOR_REGEX);
				Map<String, EClass> eClassMap = getEClassesFromEPackage(targetMetamodel);
				if (!eClassMap.isEmpty()) {
					for (String key : eClassMap.keySet()) {
						if (key.equals(identifier) || resolveFuzzy) {
							result.addMapping(key, eClassMap.get(key));
							if (!resolveFuzzy) {
								return;
							}
						}
					}
				} else {
					if(segments.length == 1){
						result.setErrorMessage("Metaclass '" + segments[0] + "' doesn't exist in " + targetMetamodel.getNsURI());
					} else {
						String packageString = "";
						for (int i = 0; i < segments.length - 1; i++) {
							packageString += segments[i] + PACKAGE_SEPARATOR;
						}
						StringBuilder builder = new StringBuilder(packageString);
						builder.deleteCharAt(builder.length() - 1);
						result.setErrorMessage("Metaclass '" + segments[segments.length - 1] + "' doesn't exist in " + targetMetamodel.getNsURI() + "/" + builder.toString());
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
	 * @param ePackage the package to search in
	 * @return
	 */
	private Map<String, EClass> getEClassesFromEPackage(EPackage ePackage) {
		Map<String, EClass> foundEClasses = new LinkedHashMap<String, EClass>();
		List<EClassifier> eClassifiers = ePackage.getEClassifiers();
		for (EClassifier eClassifier : eClassifiers) {
			if (eClassifier instanceof EClass) {
				foundEClasses.put(eClassifier.getName(), (EClass) eClassifier);
			}
		}

		List<EPackage> subPackages = ePackage.getESubpackages();
		for (EPackage subpackage : subPackages) {
			Map<String, EClass> eClassesInSubPackage = getEClassesFromEPackage(subpackage);
			for (String key : eClassesInSubPackage.keySet()) {
				foundEClasses.put(subpackage.getName() + PACKAGE_SEPARATOR + key, eClassesInSubPackage.get(key));
			}
		}
		return foundEClasses;
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
	}
}
