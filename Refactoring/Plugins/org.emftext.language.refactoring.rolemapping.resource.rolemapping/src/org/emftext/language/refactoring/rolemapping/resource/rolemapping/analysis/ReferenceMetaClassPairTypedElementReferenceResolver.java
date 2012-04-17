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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair;

public class ReferenceMetaClassPairTypedElementReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair, org.eclipse.emf.ecore.ETypedElement> {

	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair, org.eclipse.emf.ecore.ETypedElement> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair, org.eclipse.emf.ecore.ETypedElement>();

	public void resolve(String identifier, org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.ETypedElement> result) {
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
			Map<String, ETypedElement> foundTypedElements = getTypedElements(identifier, metaclass, tempPairList);
			boolean found = false;
			if (!foundTypedElements.isEmpty()) {
				for (String referenceName : foundTypedElements.keySet()) {
					if (referenceName.equals(identifier) || resolveFuzzy) {
						result.addMapping(referenceName, foundTypedElements.get(referenceName));
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

	private Map<String, ETypedElement> getTypedElements(String targetIdentifier, EClass metaClass, List<ReferenceMetaClassPair> pairs){
		Map<String, ETypedElement> foundTypedElements = new LinkedHashMap<String, ETypedElement>();
		ReferenceMetaClassPair pair = pairs.get(0);
		pairs.remove(pair);
		if(pairs.size() == 0){
			List<ETypedElement> typedElements = new ArrayList<ETypedElement>();
			typedElements.addAll(metaClass.getEAllReferences());
			List<EOperation> allOperations = metaClass.getEAllOperations();
			for (EOperation operation : allOperations) {
				EClassifier classifier = operation.getEType();
				List<EParameter> parameters = operation.getEParameters();
				if(classifier instanceof EClass && parameters.size() == 0){
					typedElements.add(operation);
				}
			}
			for (ETypedElement typedElement : typedElements) {
				if(targetIdentifier.equals(typedElement.getName())){
					pair.setTypedElement(typedElement);
					EClass pairClass = pair.getMetaClass();
					if(pairClass == null || pairClass.eIsProxy()){
						EClass eclass = (EClass) typedElement.getEType();
						pair.setMetaClass(eclass);
						if(typedElement instanceof EReference){
							EClass referenceType = ((EReference) typedElement).getEReferenceType();
							//						if(!referenceType.isAbstract()){
							//							pairClass = referenceType;
							pair.setMetaClass(referenceType);
							//						} 
						}
					}
				}
				foundTypedElements.put(typedElement.getName(), typedElement);
			}
		} else {
			EClass stepClass = pair.getMetaClass();
			if(stepClass == null){
				ETypedElement typedElement = pair.getTypedElement();
				EClass eclass = (EClass) typedElement.getEType();
				stepClass = eclass;
				pair.setMetaClass(eclass);

				if(typedElement instanceof EReference){
					EReference reference = (EReference) typedElement;
					EClass referenceType = reference.getEReferenceType();
					//				if(!referenceType.isAbstract()){
					stepClass = referenceType;
					pair.setMetaClass(referenceType);
					//				} 
				}
			}
			foundTypedElements.putAll(getTypedElements(targetIdentifier, stepClass, pairs));
		}
		return foundTypedElements;
	}

	public String deResolve(org.eclipse.emf.ecore.ETypedElement element, org.emftext.language.refactoring.rolemapping.ReferenceMetaClassPair container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}

}
