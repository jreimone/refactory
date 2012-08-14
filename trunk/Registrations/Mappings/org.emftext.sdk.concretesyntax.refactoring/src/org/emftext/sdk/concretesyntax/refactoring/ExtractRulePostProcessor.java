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
package org.emftext.sdk.concretesyntax.refactoring;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.SyntaxElement;

/**
 * A post processor for the 'Extract Rule' refactoring of the
 * CS language. The post processor mainly established the reference
 * between the old rule (i.e., the one elements were removed from)
 * and the new rule. It does so by creating a new meta class and a
 * containment reference from the meta class of the old rule.
 */
// TODO the role mapping specified to put the moved elements in
// reference 'children' of class 'Role'. This is wrong, because
// this reference has type 'SyntaxElement', but is supposed to
// hold exactly one element of type 'Choice' only. We must either
// change the mapping or repair this while post processing.
public class ExtractRulePostProcessor extends AbstractRefactoringPostProcessor {

	private static final String PLUGIN_ID = "org.emftext.sdk.concretesyntax.refactoring";

	public ExtractRulePostProcessor() {
		super();
	}

	public IStatus process(Map<Role, List<EObject>> roleMap, ResourceSet resourceSet, ChangeDescription change) {
		EObject newContainer = getEObjectByName(roleMap, "NewContainer");
		if (newContainer == null) {
			return new Status(IStatus.ERROR, PLUGIN_ID, "NewContainer error");
		}
		EObject oldContainer = getEObjectByName(roleMap, "OrigContainer");
		if (oldContainer == null) {
			// fail
			return new Status(IStatus.ERROR, PLUGIN_ID, "OrigContainer error");
		}
		if (!(oldContainer instanceof SyntaxElement)) {
			// fail
			return new Status(IStatus.ERROR, PLUGIN_ID, "SyntaxElement error");
		}
		EObject movedReference = getEObjectByName(roleMap, "MovedReference");
		if (movedReference == null) {
			// fail
			return new Status(IStatus.ERROR, PLUGIN_ID, "MovedReference error");
		}
		if (!(movedReference instanceof Containment)) {
			// fail
			return new Status(IStatus.ERROR, PLUGIN_ID, "Containment error");
		}

		Containment newContainment = (Containment) movedReference;

		Rule oldRule = getContainingRule(oldContainer);
		if (oldRule == null) {
			// fail
			return new Status(IStatus.ERROR, PLUGIN_ID, "Old rule error");
		}
		Rule newRule = getContainingRule(newContainer);
		if (newRule == null) {
			// fail
			return new Status(IStatus.ERROR, PLUGIN_ID, "New rule error");
		}

		// Create new meta class
		EClass newEClass = EcoreFactory.eINSTANCE.createEClass();
		newEClass.setName("NewClass"); // TODO avoid name clashes
		GenClass newGenClass = GenModelFactory.eINSTANCE.createGenClass();
		newGenClass.setEcoreClass(newEClass);

		// Add new meta class to packages of old rule
		GenClass oldMetaclass = oldRule.getMetaclass();
		EPackage ePackage = oldMetaclass.getEcoreClass().getEPackage();
		ePackage.getEClassifiers().add(newEClass);
		GenPackage genPackage = oldMetaclass.getGenPackage();
		genPackage.getGenClasses().add(newGenClass);

		// Add new containment feature
		EReference newContainmentEFeature = EcoreFactory.eINSTANCE.createEReference();
		newContainmentEFeature.setName("newClass");
		newContainmentEFeature.setContainment(true);
		newContainmentEFeature.setEType(newEClass);
		GenFeature newContainmentGenFeature = GenModelFactory.eINSTANCE.createGenFeature();
		newContainmentGenFeature.setEcoreFeature(newContainmentEFeature);
		oldMetaclass.getEcoreClass().getEStructuralFeatures().add(newContainmentEFeature);
		oldMetaclass.getGenFeatures().add(newContainmentGenFeature);

		// Add containment reference in old rule to new class
		newContainment.setFeature(newContainmentGenFeature);

		// Set new meta class in new rule
		newRule.setMetaclass(newGenClass);
		return new Status(IStatus.OK, PLUGIN_ID, "");
	}

	private Rule getContainingRule(EObject object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Rule) {
			return (Rule) object;
		} else {
			EObject parent = object.eContainer();
			return getContainingRule(parent);
		}
	}

	private EObject getEObjectByName(Map<Role, List<EObject>> roleMap, String roleName) {
		Set<Role> roles = roleMap.keySet();
		for (Role role : roles) {
			if (roleName.equals(role.getName())) {
				List<EObject> object = roleMap.get(role);
				return object.get(0);
			}
		}
		return null;
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec) {
		return process(roleRuntimeInstanceMap, resourceSet, change);
	}
}
