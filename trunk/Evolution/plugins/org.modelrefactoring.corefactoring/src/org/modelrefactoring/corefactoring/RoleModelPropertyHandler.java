package org.modelrefactoring.corefactoring;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.mvel2.integration.PropertyHandler;
import org.mvel2.integration.VariableResolverFactory;

public class RoleModelPropertyHandler implements PropertyHandler {

	private RoleMapping initialRoleMapping;
	private Map<Role, List<EObject>> roleBindings;
	private RoleMapping dependentRoleMapping;
	private EObject dependentModel;

	public RoleModelPropertyHandler(RoleMapping initialRoleMapping, Map<Role, List<EObject>> roleBindings, RoleMapping dependentRoleMapping, EObject dependentModel) {
		this.initialRoleMapping = initialRoleMapping;
		this.roleBindings = roleBindings;
		this.dependentRoleMapping = dependentRoleMapping;
		this.dependentModel = dependentModel;
	}

	@Override
	public Object getProperty(String arg0, Object arg1, VariableResolverFactory arg2) {
		for (Role role : roleBindings.keySet()) {
			if(role.getName().equals(arg0)){
//				return roleBindings.get(role);
				return role;
			}
		}
		return null;
	}

	@Override
	public Object setProperty(String arg0, Object arg1, VariableResolverFactory arg2, Object arg3) {
		System.out.println();
		return null;
	}

}
