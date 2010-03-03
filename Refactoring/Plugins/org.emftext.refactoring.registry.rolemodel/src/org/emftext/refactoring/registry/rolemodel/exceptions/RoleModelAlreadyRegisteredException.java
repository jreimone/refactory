package org.emftext.refactoring.registry.rolemodel.exceptions;

import org.emftext.language.refactoring.roles.RoleModel;

public class RoleModelAlreadyRegisteredException extends Exception {

	private static final long serialVersionUID = 3564300797985782107L;
	private static final String MESSAGE = "RoleModel with name '%1$s' already registered";

	private RoleModel roleModel;
	
	public RoleModelAlreadyRegisteredException(RoleModel roleModel){
		super(String.format(MESSAGE, roleModel.getName()));
		this.roleModel = roleModel;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}
}
