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
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;

public class ReferenceMetaClassPairReferenceReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair, org.eclipse.emf.ecore.EReference> {

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		EObject parent = container.eContainer().eContainer();
		if(parent instanceof ConcreteMapping){
			ConcreteMapping concreteMapping = (ConcreteMapping) parent;
			EClass metaclass = concreteMapping.getMetaclass();
			CollaborationMapping relationMapping = (CollaborationMapping) container.eContainer();

			List<ReferenceMetaClassPair> referencePairs = relationMapping.getReferenceMetaClassPair();
			List<ReferenceMetaClassPair> tempPairList = new LinkedList<ReferenceMetaClassPair>();
			for (ReferenceMetaClassPair referenceMetaClassPair : referencePairs) {
				tempPairList.add(referenceMetaClassPair);
			}
			int index = tempPairList.indexOf(container);
			int size = tempPairList.size();
			for (int i = index + 1; i < size; i++) {
				tempPairList.remove(index + 1);
			}
			//			this.result = result;
			Map<String, EReference> foundReferences = getReferences(identifier, metaclass, tempPairList);
			boolean found = false;
			if (!foundReferences.isEmpty()) {
				for (String referenceName : foundReferences.keySet()) {
					if (referenceName.equals(identifier) || resolveFuzzy) {
						result.addMapping(referenceName, foundReferences.get(referenceName));
						found = true;
						if (!resolveFuzzy) {
							return;
						}
					}
				}
			}
			if(!found){
				String className = null;
				if(index == 0){
					className = metaclass.getName();
				} else {
					className = referencePairs.get(index - 1).getMetaClass().getName();
				}
				result.setErrorMessage("Reference '" + identifier + "' is not a reference of metaclass '" + className + "'");
			}
		}
	}

	private Map<String, EReference> getReferences(String targetIdentifier, EClass metaClass, List<ReferenceMetaClassPair> pairs){
		Map<String, EReference> foundReferences = new LinkedHashMap<String, EReference>();
		ReferenceMetaClassPair pair = pairs.get(0);
		pairs.remove(pair);
		if(pairs.size() == 0){
			List<EReference> references = metaClass.getEAllReferences();
			for (EReference eReference : references) {
				if(targetIdentifier.equals(eReference.getName())){
					pair.setReference(eReference);
					EClass pairClass = pair.getMetaClass();
					if(pairClass == null || pairClass.eIsProxy()){
						EClass referenceType = eReference.getEReferenceType();
//						if(!referenceType.isAbstract()){
//							pairClass = referenceType;
							pair.setMetaClass(referenceType);
//						} 
					}
				}
				foundReferences.put(eReference.getName(), eReference);
			}
		} else {
			EClass stepClass = pair.getMetaClass();
			if(stepClass == null){
				EReference reference = pair.getReference();
				EClass referenceType = reference.getEReferenceType();
//				if(!referenceType.isAbstract()){
					stepClass = referenceType;
					pair.setMetaClass(referenceType);
//				} 
			}
			foundReferences.putAll(getReferences(targetIdentifier, stepClass, pairs));
		}
		return foundReferences;
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EReference element, org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
//		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
