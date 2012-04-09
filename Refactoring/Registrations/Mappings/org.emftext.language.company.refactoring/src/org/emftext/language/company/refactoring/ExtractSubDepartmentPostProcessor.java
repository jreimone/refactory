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
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.registry.rolemapping.AbstractRefactoringPostProcessor;

public class ExtractSubDepartmentPostProcessor extends AbstractRefactoringPostProcessor {

	public ExtractSubDepartmentPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap, ResourceSet resourceSet, ChangeDescription change) {
		List<EObject> extractees = getInstancesByRoleName(roleRuntimeInstanceMap, "Extractee");
		List<EObject> containers = getInstancesByRoleName(roleRuntimeInstanceMap, "NewContainer");
		Department container = (Department) containers.get(0);
		if(container != null && extractees != null && extractees.size() > 0){
			Employee manager = (Employee) extractees.get(0);
//			extractees.remove(0);
			container.setManager(manager);
		}
		return Status.OK_STATUS;
	}


	private List<EObject> getInstancesByRoleName(Map<Role, List<EObject>> roleRuntimeInstanceMap, String roleName){
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		for (Role role : roles) {
			if(role.getName().equals(roleName)){
				return roleRuntimeInstanceMap.get(role);
			}
		}
		return null;
	}

}
