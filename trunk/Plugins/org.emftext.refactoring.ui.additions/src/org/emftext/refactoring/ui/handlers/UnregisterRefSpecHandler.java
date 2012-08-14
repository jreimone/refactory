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

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;

public class UnregisterRefSpecHandler extends RegisterRefSpecHandler {

	@Override
	protected void executeWithModelInTextEditor(RefactoringSpecification model) {
		RefactoringSpecification unregisteredRefSpec = IRefactoringSpecificationRegistry.INSTANCE.unregisterRefSpec(model);
		//TODO unregister all corresponding rolemappings
		if(unregisteredRefSpec == null){
			UIUtil.showToolTip("Unregistering RefactoringSpecification"
					, "RefactoringSpecification for '" + model.getUsedRoleModel().getName() + "' couldn't be unregistered.\nIt never was registered."
					, getEditor());
		}
	}
}
