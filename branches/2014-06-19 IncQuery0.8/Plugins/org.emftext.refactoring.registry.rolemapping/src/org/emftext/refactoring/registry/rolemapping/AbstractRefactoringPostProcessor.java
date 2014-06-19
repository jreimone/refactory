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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;
import org.emftext.refactoring.util.RoleUtil;

/**
 * Abstract class implementing basic functionality of {@link IRefactoringPostProcessor IRefactoringPostProcessor}.
 * The main purpose of this class is to ease further development of the IRefactoringPostProcessor interface
 * by providing backwards comatibility. Furthermore, newer versions of concrete post processors do not need to
 * implement the deprecated interface.
 * 
 * @author Christoph Seidl, Jan Reimann
 */
public class AbstractRefactoringPostProcessor implements IRefactoringPostProcessor {

	// 1st API release
	@Deprecated
	public IStatus process(Map<Role, List<EObject>> roleBindings, ResourceSet resourceSet, ChangeDescription change) {
		return Status.OK_STATUS;
	}
	
	// 2nd API release
	@Deprecated
	public IStatus process(Map<Role, List<EObject>> roleBindings, EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier, List<? extends EObject> initialSelection) {
		return process(roleBindings, resourceSet, change);
	}
	
	// 3rd API release
	public IStatus process(Map<Role, List<EObject>> roleBindings, EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun, Map<EObject, EObject> copier) {
		//Provide backwards compatibility for those classes that need it.
		//All others may simply override this method.
		List<EObject> initialSelection = RoleUtil.getBoundInputElements(roleBindings);
		return process(roleBindings, refactoredModel, resourceSet, change, refSpec, customWizardPages, isFakeRun, copier, initialSelection);
	}
}
