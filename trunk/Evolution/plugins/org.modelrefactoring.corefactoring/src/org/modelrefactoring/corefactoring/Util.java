package org.modelrefactoring.corefactoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, Object> bindings = getRoleNameBindings(initialRefactorer.getRoleBindings());
		bindings.put(IN, initialRefactorer.getOriginalModel());
		return bindings;
	}
	
	public static Map<String, Object> getOutRoleNameBindings(EObject dependentModel, RoleMapping dependentRoleMapping, List<EObject> dependentInput){
		Map<String, Object> bindings = new HashMap<String, Object>();
		List<Role> inputRoles = RoleUtil.getAllInputRoles(dependentRoleMapping);
		for (Role role : inputRoles) {
			List<EObject> filteredObjects = RoleUtil.filterObjectsByRoles(dependentInput, dependentRoleMapping, role);
			bindings.put(role.getName(), filteredObjects);
		}
		bindings.put(OUT, dependentModel);
		return bindings;
	}
	
	public static Map<String, Object> getRoleNameBindings(IRefactorer refactorer){
		return getRoleNameBindings(refactorer.getRoleBindings());
	}

	public static Map<String, Object> getOutRoleNameBindings(EObject fakeRefactoredModel, RoleMapping dependentRoleMapping, Map<Role, List<EObject>> dependentModelRoleBindings) {
		Map<String, Object> bindings = getRoleNameBindings(dependentModelRoleBindings);
		bindings.put(OUT, fakeRefactoredModel);
		return bindings;
	}
}
