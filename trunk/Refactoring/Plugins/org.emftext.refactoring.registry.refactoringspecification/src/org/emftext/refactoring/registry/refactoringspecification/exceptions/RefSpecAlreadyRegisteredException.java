package org.emftext.refactoring.registry.refactoringspecification.exceptions;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;

public class RefSpecAlreadyRegisteredException extends Exception {

	private static final long serialVersionUID = 6760747409240262340L;

	private static final String MESSAGE = "RefSpec for RoleModel '%1$s' already registered";

	private RefactoringSpecification refSpec;
	
	public RefSpecAlreadyRegisteredException(RefactoringSpecification refSpec){
		super(String.format(MESSAGE, refSpec.getUsedRoleModel().getName()));
		this.refSpec = refSpec;
	}

	public RefactoringSpecification getRefSpec() {
		return refSpec;
	}
}
