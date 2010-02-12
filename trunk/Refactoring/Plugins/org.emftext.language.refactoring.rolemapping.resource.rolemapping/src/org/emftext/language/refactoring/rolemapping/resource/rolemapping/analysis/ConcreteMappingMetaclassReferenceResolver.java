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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class ConcreteMappingMetaclassReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass> {
	
	private org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis.RolemappingDefaultResolverDelegate<org.emftext.language.refactoring.rolemapping.ConcreteMapping, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EObject parent = container.eContainer().eContainer();
		if (parent instanceof RoleMappingModel) {
			RoleMappingModel mappingModel = (RoleMappingModel) parent;
			EPackage targetMetamodel = mappingModel.getTargetMetamodel();
			if (targetMetamodel != null && !targetMetamodel.eIsProxy()) {
				List<EClassifier> eClassifiers = targetMetamodel.getEClassifiers();
				for (EClassifier eClassifier : eClassifiers) {
					if (eClassifier.getName().equals(identifier) || resolveFuzzy) {
						if (eClassifier instanceof EClass) {
							result.addMapping(eClassifier.getName(), (EClass) eClassifier);
						}
					}
				}
			}
		} else {
			assert false;
		}
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.refactoring.rolemapping.ConcreteMapping container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
