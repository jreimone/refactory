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
package org.emftext.refactoring.ltk;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.util.RoleUtil;

public abstract class ModelRefactoringWizardPage extends UserInputWizardPage implements IModelRefactoringWizardPage
{
	private Map<Role, List<EObject>> roleRuntimeInstanceMap;
	
	public ModelRefactoringWizardPage(String name)
	{
		super(name);
		
		setDescription("The refactoring requires additional parameters.");
	}

	public void createControl(Composite parent)
	{
		Control c = doCreateControl(parent);

		setControl(c);
	}
	
	protected abstract Control doCreateControl(Composite parent);
	
	public void setRoleRuntimeInstanceMap(Map<Role, List<EObject>> roleRuntimeInstanceMap)
	{
		this.roleRuntimeInstanceMap = roleRuntimeInstanceMap;
	}
	
	protected <T extends EObject> T getFirstObjectForRole(String roleName, Class<T> type)
	{
		return RoleUtil.getFirstObjectForRole(roleName, type, roleRuntimeInstanceMap);
	}

	protected <T extends EObject> List<T> getObjectsForRole(String roleName, Class<T> type)
	{
		return RoleUtil.getObjectsForRole(roleName, type, roleRuntimeInstanceMap);
	}
}
