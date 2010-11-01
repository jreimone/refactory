package org.emftext.language.refactoring.roles.quickfixes;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextQuickFix;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.ui.RefactoringAction;

public class RenameRoleRefactoringQuickFix extends RolestextQuickFix {

	private static final String REFACTOR_RENAME_OTHER_ROLE = "Refactor: Rename other role";

	private IRefactorer refactorer;
	private RoleMapping mapping;

	public RenameRoleRefactoringQuickFix(RoleMapping mapping, Role roleToBeRefactored, IRefactorer refactorer, String iconKey){
		super(REFACTOR_RENAME_OTHER_ROLE, iconKey, roleToBeRefactored);
		this.refactorer = refactorer;
		this.mapping = mapping;
	}

	@Override
	public void applyChanges() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IEditorConnector connector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
		if(connector != null){
			RefactoringAction action = new RefactoringAction(mapping, refactorer, connector);
			action.run();
		}
	}
}
