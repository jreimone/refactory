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
package org.emftext.language.company.refactoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.company.Department;
import org.emftext.language.company.Employee;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

public class ExtractSubDepartmentPostProcessor extends AbstractRefactoringPostProcessor {

	private Map<EObject, EObject> inverseCopier;
	
	@SuppressWarnings("unchecked")
	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		List<Employee> extractees = (List<Employee>) getInstancesByRoleName(roleRuntimeInstanceMap, "Extractee");
		List<Department> containers = (List<Department>) getInstancesByRoleName(roleRuntimeInstanceMap, "NewContainer");
		Department container = (Department) containers.get(0);
		if(container != null && extractees != null && extractees.size() > 0){
			if(isFakeRun){
				Employee manager = extractees.get(0);
				container.setManager(manager);
				inverseCopier = getInverseCopier(copier);
			} else {
				for (IModelRefactoringWizardPage wizardPage : customWizardPages) {
					if(wizardPage instanceof SetManagerWizardPage){
						//TODO set correct elements with copier?
						SetManagerWizardPage setManagerPage = (SetManagerWizardPage) wizardPage;
						Employee manager = setManagerPage.getSelectedEmployee();
						Employee realManager = null;
						if(inverseCopier != null){
							realManager = (Employee) inverseCopier.get(manager);
						}
						if(realManager != null){
							container.setManager(realManager);
						}
					}
				}
			}
		}
		return Status.OK_STATUS;
	}

	private Map<EObject, EObject> getInverseCopier(Map<EObject, EObject> copier){
		if(copier == null){
			return null;
		}
		Map<EObject, EObject> inverseCopier = new HashMap<EObject, EObject>();
		for (EObject key : copier.keySet()) {
			inverseCopier.put(copier.get(key), key);
		}
		return inverseCopier;
	}
	
	private List<? extends EObject> getInstancesByRoleName(Map<Role, List<EObject>> roleRuntimeInstanceMap, String roleName){
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			if(role.getName().equals(roleName)){
				return roleRuntimeInstanceMap.get(role);
			}
		}
		return null;
	}

}
