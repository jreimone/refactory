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
package org.emftext.refactoring.movextowards;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.refactoring.util.RoleUtil;

public abstract class AbstractMoveXTowardsPostProcessor extends	AbstractRefactoringPostProcessor {

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier) {
		EObject container = RoleUtil.getFirstObjectForRole("Container",	EObject.class, roleRuntimeInstanceMap);
		EObject element = RoleUtil.getFirstObjectForRole("Element",	EObject.class, roleRuntimeInstanceMap);

		EObject realContainer = element.eContainer();

		// The real container is not the object that was expected.
		// Cancel refactoring.
		if (!EcoreUtil.equals(container, realContainer)) {
			return Status.CANCEL_STATUS;
		}

		InternalEObject internalEObject = (InternalEObject) element;
		EObject internalContainer = internalEObject.eInternalContainer();

		EReference feature = element.eContainmentFeature();

		if (FeatureMapUtil.isMany(internalContainer, feature)) {
			@SuppressWarnings("unchecked")
			List<Object> list = (List<Object>) internalContainer.eGet(feature);
			moveElement(list, element);
		}

		return Status.OK_STATUS;
	}

	protected void moveElement(List<Object> objects, EObject element) {
		int index = objects.indexOf(element);

		if (index != -1) {
			int newIndex = determineNewIndex(index, objects.size());

			objects.remove(element);
			objects.add(newIndex, element);
		}
	}

	protected abstract int determineNewIndex(int index, int numberOfElements);
}
