package org.modelrefactoring.corefactoring;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.mvel2.integration.impl.MapVariableResolver;

public class RoleModelVariableResolver extends MapVariableResolver {

	private static final long serialVersionUID = -2295234042921075945L;
	private RoleModel mappedRoleModel;
	private Map<Role, List<EObject>> roleBindings;
	private Map<String, Object> variables;
	private RoleMapping roleMapping;

	public RoleModelVariableResolver(String name, RoleModel mappedRoleModel, Map<Role, List<EObject>> roleBindings, Map<String, Object> variables) {
		super(variables, name);
		this.mappedRoleModel = mappedRoleModel;
		this.roleBindings = roleBindings;
		this.variables = variables;
	}

	public RoleModelVariableResolver(String name, RoleMapping dependentRoleMapping, Map<String, Object> variables) {
		this(name, dependentRoleMapping.getMappedRoleModel(), null, variables);
		this.roleMapping = dependentRoleMapping;
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public void setStaticType(Class knownType) {
		super.setStaticType(knownType);
	}

	@Override
	public void setVariableMap(Map<String, Object> variableMap) {
		super.setVariableMap(variableMap);
	}

	@Override
	public int getFlags() {
		return super.getFlags();
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public Class getType() {
		return Role.class;
	}

	@Override
	public Object getValue() {
		String name = getName();
		if(name.equals("IN") || name.equals("OUT")){
			return mappedRoleModel;
		}
		return super.getValue();
	}

	@Override
	public void setValue(Object arg0) {
		super.setValue(arg0);
	}

}
