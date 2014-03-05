package org.modelrefactoring.corefactoring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.impl.BaseVariableResolverFactory;

public class RoleBindingResolverFactory extends BaseVariableResolverFactory {

	private static final long serialVersionUID = 8406088059690087658L;

	private static final String IN	= "IN";
	private static final String OUT	= "OUT";
	private static final String[] STATIC_VARS = new String[]{IN, OUT};

	private RoleMapping initialRoleMapping;
	private Map<Role, List<EObject>> roleBindings;
	private RoleMapping dependentRoleMapping;
	private EObject dependentModel;

	public RoleBindingResolverFactory(RoleMapping initialRoleMapping, Map<Role, List<EObject>> roleBindings, RoleMapping dependentRoleMapping, EObject dependentModel) {
		this.initialRoleMapping = initialRoleMapping;
		this.roleBindings = roleBindings;
		this.dependentRoleMapping = dependentRoleMapping;
		this.dependentModel = dependentModel;
	}

	@Override
	public VariableResolver createVariable(String arg0, Object arg1) {
		System.out.println();
		return null;
	}

	@Override
	public VariableResolver createVariable(String arg0, Object arg1, Class<?> arg2) {
		System.out.println();
		return null;
	}

	@Override
	public boolean isResolveable(String arg0) {
		for (String var : STATIC_VARS) {
			if(var.equals(arg0)){
				return true;
			}
		}
		return false;
	}

	@Override
	public VariableResolver getVariableResolver(String name) {
		if(IN.equals(name)){
			Map<String, Object> variables = new HashMap<String, Object>();
			for (Role role : roleBindings.keySet()) {
				variables.put(role.getName(), roleBindings.get(role));
			}
			return new RoleModelVariableResolver(name, initialRoleMapping.getMappedRoleModel(), roleBindings, variables);
		} else if(OUT.equals(name)){
			Map<String, Object> variables = new HashMap<String, Object>();
			for (Role role : dependentRoleMapping.getAllMappedRoles()) {
				variables.put(role.getName(), new ArrayList<EObject>());
			}
			return new RoleModelVariableResolver(name, dependentRoleMapping, variables);
		}
		return super.getVariableResolver(name);
	}

	@Override
	public boolean isTarget(String arg0) {
		System.out.println();
		return false;
	}

}
