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
package org.emftext.refactoring.duplicatex;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public class DuplicateXPostProcessor extends AbstractRefactoringPostProcessor {
	/**
	 * Specialized copier that does not copy child elements.
	 * 
	 * @author Christoph Seidl
	 */
	private class DirectCopier extends Copier {
		private static final long serialVersionUID = 1L;

//		@Override
//		protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
//			// Do not copy containment references.
//		}
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		EObject container = RoleUtil.getFirstObjectForRole("Container",	EObject.class, roleRuntimeInstanceMap);
		EObject element = RoleUtil.getFirstObjectForRole("Element",	EObject.class, roleRuntimeInstanceMap);

		EObject realContainer = element.eContainer();

		// The real container is not the object that was expected.
		// Cancel refactoring.
		if (!EcoreUtil.equals(container, realContainer)) {
			return Status.CANCEL_STATUS;
		}

		// Create a copy of the element and add it directly behind the original.
		InternalEObject internalEObject = (InternalEObject) element;
		EObject internalContainer = internalEObject.eInternalContainer();

		EReference feature = element.eContainmentFeature();

		if (FeatureMapUtil.isMany(internalContainer, feature)) {
			@SuppressWarnings("unchecked")
			List<Object> list = (List<Object>) internalContainer.eGet(feature);
			int index = list.indexOf(element);

			Copier directCopier = new DirectCopier();
			EObject copiedElement = directCopier.copy(element);
			directCopier.copyReferences();

			list.add(index + 1, copiedElement);

			// Let the roleRuntimeInstanceMap know of the copy to keep things
			// consistent.
			List<EObject> copiedElements = getRawObjectsForRole(
					"CopiedElement", roleRuntimeInstanceMap);

			if (copiedElements != null) {
				// Object contained so far is a dummy that has to be deleted.
				copiedElements.clear();
				copiedElements.add(copiedElement);
			}
		}

		return Status.OK_STATUS;
	}

	private static List<EObject> getRawObjectsForRole(String roleName, Map<Role, List<EObject>> roleRuntimeInstanceMap) {
		Set<Role> roles = roleRuntimeInstanceMap.keySet();

		for (Role role : roles) {
			if (role.getName().equals(roleName)) {
				return roleRuntimeInstanceMap.get(role);
			}
		}

		return null;
	}
}
