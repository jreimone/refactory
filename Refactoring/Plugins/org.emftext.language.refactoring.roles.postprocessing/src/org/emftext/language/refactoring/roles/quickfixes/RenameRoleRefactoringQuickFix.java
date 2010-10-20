package org.emftext.language.refactoring.roles.quickfixes;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextQuickFix;
import org.emftext.refactoring.interpreter.IRefactorer;

public class RenameRoleRefactoringQuickFix extends RolestextQuickFix {

	private IRefactorer refactorer;
	private Role secondRole;
	private String originalName;

	public RenameRoleRefactoringQuickFix(Role roleToBeRefactored, Role secondRole, String originalName, IRefactorer refactorer){
		super("Refactor: Rename other role", null, roleToBeRefactored);
		this.secondRole = secondRole;
		this.refactorer = refactorer;
		this.originalName = originalName;
	}

	@Override
	public void applyChanges() {
		refactorer.refactor();
		secondRole.setName(originalName);
	}

}
