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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class ConcreteMappingMetaclassReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass> {

	private static final String PACKAGE_SEPARATOR = "\\.";

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
				String[] segments = identifier.split(PACKAGE_SEPARATOR);
				EClass mappedClass = getEClassFromEPackage(targetMetamodel, segments, resolveFuzzy);
				if(mappedClass != null){
					result.addMapping(identifier, mappedClass);
					if (!resolveFuzzy) {
						return;
					}
				} else {
					if(segments.length == 1){
						result.setErrorMessage("Metaclass '" + segments[0] + "' doesn't exist in " + targetMetamodel.getNsURI());
					} else {
						String packageString = "";
						for (int i = 0; i < segments.length - 1; i++) {
							packageString += segments[i] + ".";
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

	private EClass getEClassFromEPackage(EPackage epackage, String[] identifierPath, boolean resolveFuzzy){
		if(identifierPath.length == 1){
			String className = identifierPath[0];
			List<EClassifier> eClassifiers = epackage.getEClassifiers();
			for (EClassifier eClassifier : eClassifiers) {
				if (eClassifier.getName().equals(className) || resolveFuzzy) {
					if (eClassifier instanceof EClass) {
						return (EClass) eClassifier;
					}
				}
			}
		} else {
			String identifier = identifierPath[0];
			identifierPath = removeFirst(identifierPath);
			List<EPackage> subPackages = epackage.getESubpackages();
			for (EPackage subpackage : subPackages) {
				if(subpackage.getName().equals(identifier)){
					return getEClassFromEPackage(subpackage, identifierPath, resolveFuzzy);
				}
			}
		}
		return null;
	}

	private static String[] removeFirst(String[] path) {
		List<String> temp = new ArrayList<String>();
		for (int i = 1; i < path.length; i++) {
			temp.add(path[i]);
		}
		return temp.toArray(new String[0]);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
	}
}
