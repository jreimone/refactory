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
package org.emftext.language.refactoring.roles.quickfixes;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextQuickFix;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.ui.RefactoringAction;

public class RenameRoleRefactoringQuickFix extends RolestextQuickFix {

	private static final String REFACTOR_RENAME_OTHER_ROLE = "Refactor: Rename other role";

	private IRefactorer refactorer;

	public RenameRoleRefactoringQuickFix(Role roleToBeRefactored, IRefactorer refactorer, String iconKey){
		super(REFACTOR_RENAME_OTHER_ROLE, iconKey, roleToBeRefactored);
		this.refactorer = refactorer;
	}

	@Override
	public void applyChanges() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IEditorConnector connector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
		if(connector != null){
			RefactoringAction action = new RefactoringAction(refactorer, connector);
			action.run();
		}
	}
}
