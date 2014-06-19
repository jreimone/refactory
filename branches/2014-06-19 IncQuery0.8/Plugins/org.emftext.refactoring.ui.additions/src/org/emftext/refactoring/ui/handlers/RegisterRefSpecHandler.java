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
package org.emftext.refactoring.ui.handlers;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.specification.resource.IRefspecTextResource;
import org.emftext.language.refactoring.specification.resource.ui.RefspecEditor;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;

public class RegisterRefSpecHandler extends AbstractModelHandler<RefactoringSpecification, IRefspecTextResource, RefspecEditor> {

	@Override
	protected boolean isModelEditorInstance(IEditorPart editor) {
		return editor instanceof RefspecEditor;
	}

	@Override
	protected IRefspecTextResource getResource(RefspecEditor editor) {
		return editor.getResource();
	}

	@Override
	protected void executeWithModelInTextEditor(RefactoringSpecification model) {
		try {
			RoleModel roleModel = IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(model);
			if(roleModel == null){
				UIUtil.showToolTip("Registering RefactoringSpecification"
						, "The RefactoringSpecification couldn't be registered because the role model wasn't found in the registry."
						, getEditor());
			}
		} catch (RefSpecAlreadyRegisteredException e) {
			UIUtil.showToolTip("Registering RefactoringSpecification"
					, "RefactoringSpecification for '" + model.getUsedRoleModel().getName() + "' couldn't be registered.\nA RefSpec was registered already."
					, getEditor());
		}
	}

	@Override
	protected RefactoringSpecification getModelFromSelection(ITextSelection selection, IRefspecTextResource resource) {
		return (RefactoringSpecification) resource.getContents().get(0);
	}

}
