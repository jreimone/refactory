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
package org.emftext.refactoring.registry.rolemapping;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.registry.rolemapping.impl.BasicCustomWizardPageRegistry;

public interface ICustomWizardPageRegistry {

	public static final ICustomWizardPageRegistry INSTANCE = new BasicCustomWizardPageRegistry();
	
//	public List<IModelRefactoringWizardPage> getFreshCustomWizardPages(RoleMapping mapping, Map<Role, List<EObject>> roleRuntimeInstanceMap);
	public List<IModelRefactoringWizardPage> getCustomWizardPages(RoleMapping mapping, Map<Role, List<EObject>> roleRuntimeInstanceMap);
	
	/**
	 * Is executed before a new refactoring is invoked for initialising the registry. This means, known
	 * registered custom wizard pages stay known but the collected values from other refactorings are removed
	 * and the page is initialised.
	 * The given <code>roleMapping</code> is used to determine the registered wizard pages.
	 * 
	 */
	public void init(RoleMapping roleMapping);
}
