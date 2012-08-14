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
package org.eclipse.emf.ecore.refactoring.postprocessors;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

public class InterfaceFromFeaturesPostProcessor extends AbstractRefactoringPostProcessor {

	public InterfaceFromFeaturesPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		EClass interfaceClass = null;
		for (Role role : roleRuntimeInstanceMap.keySet()) {
			if(role.getName().equals("NewContainer")){
				interfaceClass = (EClass) roleRuntimeInstanceMap.get(role).get(0);
			}
		}
		interfaceClass.setAbstract(true);
		interfaceClass.setInterface(true);
		return Status.OK_STATUS;
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec) {
		return process(roleRuntimeInstanceMap, resourceSet, change);
	}

}
