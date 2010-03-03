package org.emftext.refactoring.registry.rolemapping.exceptions;

import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

public class RoleMappingAlreadyRegistered extends Exception {

	private static final long serialVersionUID = -1973291825550213552L;
	private static final String MESSAGE = "RoleMapping for namespace URI '%1$s' already registered";

	private RoleMappingModel roleMapping;
	
	public RoleMappingAlreadyRegistered(RoleMappingModel roleMapping){
		super(String.format(MESSAGE, roleMapping.getTargetMetamodel().getNsURI()));
		this.roleMapping = roleMapping;
	}

	public RoleMappingModel getRoleMapping() {
		return roleMapping;
	}
	
}
