package org.modelrefactoring.corefactoring;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.util.RoleUtil;

public abstract class Util {

	public static final String IN				= "IN";
	public static final String OUT				= "OUT";
	public static final String[] STATIC_VARS 	= new String[]{IN, OUT};
	
	/**
	 * Just returns a map not containing roles as keys but their names.
	 * 
	 * @param roleBindings
	 * @return
	 */
	public static Map<String, Object> getRoleNameBindings(Map<Role, List<EObject>> roleBindings){
		Map<String, Object> roleNameBindings = new HashMap<String, Object>();
		for (Role role : roleBindings.keySet()) {
			roleNameBindings.put(role.getName(), roleBindings.get(role));
		}
		return roleNameBindings;
	}
	
	public static Map<String, Object> getInRoleNameBindings(IRefactorer initialRefactorer){
		Map<String, Object> bindings = getRoleNameBindings(initialRefactorer.getInterpreter().getRoleRuntimeInstances());
		bindings.put(IN, initialRefactorer.getOriginalModel());
		return bindings;
	}
	
	public static Map<String, Object> getOutRoleNameBindings(IRefactorer dependentRefactorer){
		@SuppressWarnings("unchecked")
		Map<String, Object> bindings = getRoleNameBindings(Collections.EMPTY_MAP);
		RoleMapping roleMapping = dependentRefactorer.getRoleMapping();
		List<EObject> input = dependentRefactorer.getInput();
		List<Role> roles = roleMapping.getMappedRoleModel().getRoles();
		for (Role role : roles) {
			List<EObject> filteredObjects = RoleUtil.filterObjectsByRoles(input, roleMapping, role);
			bindings.put(role.getName(), filteredObjects);
		}
		bindings.put(OUT, dependentRefactorer.getOriginalModel());
		return bindings;
	}
	
	public static Map<String, Object> getRoleNameBindings(IRefactorer refactorer){
		return getRoleNameBindings(refactorer.getInterpreter().getRoleRuntimeInstances());
	}
}
