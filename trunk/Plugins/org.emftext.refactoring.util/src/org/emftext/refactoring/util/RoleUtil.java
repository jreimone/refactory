/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.CREATE;
import org.emftext.language.refactoring.refactoring_specification.CollaborationReference;
import org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand;
import org.emftext.language.refactoring.refactoring_specification.RoleReference;
import org.emftext.language.refactoring.refactoring_specification.TRACE;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.refactoring_specification.VariableAssignment;
import org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModifier;

/**
 * Utility functions for models having to do with roles.
 * 
 * @author Jan Reimann
 *
 */
public class RoleUtil {

	/**
	 * Returns the appropriate Role from the given variable.
	 * 
	 * @param variable
	 * @return
	 */
	public static Role getRoleFromVariable(Variable variable) {
		VariableDeclarationCommand command = variable.getContainerCommand();
		if (command instanceof CREATE) {
			return ((CREATE) command).getSourceRole();
		} else if (command instanceof VariableAssignment) {
			VariableAssignment assignment = (VariableAssignment) command;
			ObjectAssignmentCommand objectAssignment = assignment.getAssignment();
			if (objectAssignment instanceof RoleReference) {
				return ((RoleReference) objectAssignment).getRole();
			} else if (objectAssignment instanceof TRACE) {
				return ((TRACE) objectAssignment).getRole();
			} else if (objectAssignment instanceof CollaborationReference) {
				CollaborationReference collaborationReference = (CollaborationReference) objectAssignment;
				MultiplicityCollaboration collaboration = collaborationReference.getCollaboration();
				Role target = collaboration.getTarget();
				return target;
			} else {
				throw new UnsupportedOperationException("implement this case");
			}
		}
		return null;
	}
	
	/**
	 * Given a list of objects this method returns all roles which are present in this object list
	 * depending on the given mapping.
	 * 
	 * @param objects
	 * @param mapping
	 */
	public static Set<Role> getAppliedRoles(List<? extends EObject> objects, RoleMapping mapping) {
		Set<Role> appliedRoleSet = new LinkedHashSet<Role>();
		if (objects == null) {
			return appliedRoleSet;
		}
		EcoreUtil.resolveAll(mapping.getMappedRoleModel());
		for (EObject eObject : objects) {
			EList<Role> objectRoles = mapping.getMappedRolesForEObject(eObject);
			appliedRoleSet.addAll(objectRoles);
		}
		return appliedRoleSet;
	}

	/**
	 * Returns a list containing all possible mappings having a minimal procentual equality given by 
	 * <code>minEquality</code>. To ensure that only mappings will be determined from which all roles are
	 * applied in the list of the selected objects then the value 1.0 has to be passed.
	 * 
	 * @param selection the selected objects for which the mappings will be compared to the present roles
	 * @param roleMapping
	 * @param minEquality
	 * @return
	 */
	public static List<RoleMapping> getPossibleMappingsForSelection(List<? extends EObject> selection, Map<String, RoleMapping> roleMappings, double minEquality) {
		List<RoleMapping> possibleMappings = new LinkedList<RoleMapping>();
		List<RoleMapping> mappings = (List<RoleMapping>) roleMappings.values();
		for (RoleMapping mapping : mappings) {
			double equality = getProcentualEquality(selection, mapping);
			if (Math.abs(equality) >= minEquality) {
				possibleMappings.add(mapping);
			}
		}
		return possibleMappings;
	}

	/**
	 * Does the same like {@link RoleUtil#getPossibleMappingsForSelection(List, RoleMappingModel, double)} but only compares
	 * Roles having the modifier {@link RoleModifier#INPUT}.
	 * @param selection
	 * @param roleMapping
	 * @param minEquality
	 * @return
	 */
	public static List<RoleMapping> getPossibleMappingsForInputSelection(List<? extends EObject> selection, Map<String, RoleMapping> roleMappings, double minEquality) {
		List<RoleMapping> possibleMappings = new LinkedList<RoleMapping>();
		if(roleMappings == null){
			return possibleMappings;
		}
		Collection<RoleMapping> mappings = roleMappings.values();
		for (RoleMapping mapping : mappings) {
			EcoreUtil.resolveAll(mapping);
			double equality = getProcentualInputEquality(selection, mapping);
			if (Math.abs(equality) >= minEquality) {
				possibleMappings.add(mapping);
			}
		}
		return possibleMappings;
	}

	/**
	 * Calculates the procentual equality between the applied roles of the given objects and the
	 * roles mapped in the given mapping. If all roles of the mapping were applied onto the objects
	 * then the result will be 1.0 
	 *  
	 * @param objects
	 * @param mapping
	 * @return
	 */
	public static double getProcentualEquality(List<? extends EObject> objects, RoleMapping mapping) {
		Collection<Role> allMappedRoles = getAllMappedRoles(mapping);
		Collection<Role> appliedRoles = getAppliedRoles(objects, mapping);
		double result = getProcentualRolesEquality(allMappedRoles, appliedRoles);
		return result;
	}

	/**
	 * Calculates the procentual equality between both role collections. <code>mappedRoles</code> is intended
	 * to be the list to which the other will be compared - it represents the calculation base. Then for every
	 * role in <code>appliedRoles</code> will be determined if it is contained in <code>mappedRoles</code>. If 
	 * both lists are contained in each other the result value will be 1.0
	 * 
	 * @param mappedRoles
	 * @param appliedRoles
	 * @return
	 */
	public static double getProcentualRolesEquality(Collection<Role> mappedRoles, Collection<Role> appliedRoles) {
		Collection<Role> matchedRoles = new LinkedList<Role>();
		for (Role appliedRole : appliedRoles) {
			if (mappedRoles.contains(appliedRole)) {
				matchedRoles.add(appliedRole);
			}
		}
		appliedRoles.removeAll(matchedRoles);
		mappedRoles.removeAll(matchedRoles);
		if (appliedRoles.size() == 0 && mappedRoles.size() == 0) {
			return 1.0;
		}
		double result = Double.NaN;
		if (mappedRoles.size() >= appliedRoles.size()) {
			double mappedRolesValue = new Integer(mappedRoles.size()).doubleValue();
			double matchedRolesValue = new Integer(matchedRoles.size()).doubleValue();
			result = 1.0 - ((mappedRolesValue - matchedRolesValue) / mappedRolesValue);
		} else if (matchedRoles.size() == 0) {
			return 0.0;
		} else {
			double matchedRolesValue = new Integer(matchedRoles.size()).doubleValue();
			double appliedRolesValue = new Integer(appliedRoles.size()).doubleValue();
			result = 1.0 + (appliedRolesValue / (matchedRolesValue + appliedRolesValue));
			result = -result;
		}
		return result;
	}

	/**
	 * Returns all roles mapped in the given mapping.
	 * 
	 * @param mapping
	 * @return
	 */
	public static List<Role> getAllMappedRoles(RoleMapping mapping) {
		EcoreUtil.resolveAll(mapping.getMappedRoleModel());
		return mapping.getAllMappedRoles();
	}

	/**
	 * Returns all roles of the given mapping having the modifier {@link RoleModifier#INPUT}.
	 * 
	 * @param mapping the mapping to search for input roles
	 * @return all input roles
	 */
	public static List<Role> getAllInputRoles(RoleMapping mapping) {
		return getAllModifiedRoles(mapping, RoleModifier.INPUT);
	}
	
	/**
	 * Returns all roles of the given mapping having the modifier {@link RoleModifier#OPTIONAL}.
	 * 
	 * @param mapping the mapping to search for input roles
	 * @return all input roles
	 */
	public static List<Role> getAllOptionalRoles(RoleMapping mapping) {
		return getAllModifiedRoles(mapping, RoleModifier.OPTIONAL);
	}
	
	/**
	 * Returns all roles of the given mapping having the given modifier {@link RoleModifier}.
	 * 
	 * @param mapping the mapping to search for input roles
	 * @param modifier the modifier by which the roles are filtered
	 * @return all input roles
	 */
	public static List<Role> getAllModifiedRoles(RoleMapping mapping, RoleModifier modifier) {
		List<Role> inputRoles = new LinkedList<Role>();
		List<Role> mappedRoles = getAllMappedRoles(mapping);
		for (Role role : mappedRoles) {
			if (role.getModifier().contains(modifier)) {
				inputRoles.add(role);
			}
		}
		return inputRoles;
	}

	/**
	 * Calculates the procentual equality of the given input and all roles of the given mapping having
	 * the modifier {@link RoleModifier#INPUT}. If all input roles of the mapping are contained in the
	 * <code>input</code> then the result will be 1.0
	 * 
	 * @param input
	 * @param mapping
	 * @return
	 */
	public static double getProcentualInputEquality(List<? extends EObject> input, RoleMapping mapping) {
		List<Role> inputRoles = getAllInputRoles(mapping);
		Set<Role> appliedRoles = getAppliedRoles(input, mapping);
		return getProcentualRolesEquality(inputRoles, appliedRoles);
	}

	/**
	 * Filters the given list of {@link EObject}s by the {@link EClass}es to which the input roles of the given
	 * <code>mapping</code> where mapped.
	 * 
	 * @see RoleModifier#INPUT
	 * @param objects
	 * @param mapping
	 * @return
	 */
	public static List<EObject> filterObjectsByInputRoles(List<? extends EObject> objects, RoleMapping mapping) {
		List<Role> inputRoles = getAllInputRoles(mapping);
		return filterObjectsByRoles(objects, mapping, inputRoles.toArray(new Role[0]));
	}

	/**
	 * Returns a the given list of {@link EObject}s filtered by the given <code>roles</code> how they are
	 * mapped to {@link EClass}es in the given <code>mapping</code>
	 * 
	 * @param objects
	 * @param mapping
	 * @param roles
	 * @return
	 */
	public static List<EObject> filterObjectsByRoles(List<? extends EObject> objects, RoleMapping mapping, Role... roles) {
		List<Role> roleList = Arrays.asList(roles);
		List<EObject> filteredList = new LinkedList<EObject>();
		for (EObject eObject : objects) {
			List<Role> appliedRoles = mapping.getMappedRolesForEObject(eObject);
			for (Role role : appliedRoles) {
				if (roleList.contains(role)) {
					filteredList.add(eObject);
				}
			}
		}
		return filteredList;
	}

	/**
	 * Returns the first common {@link EObject} in paths to root, as calculated by {@link ModelUtil#getPathToRoot(EObject)},
	 * having the given role applied in the given mapping. 
	 * @param paths
	 * @return
	 */
	public static EObject getFirstCommonObjectWithRoleFromPaths(Role role, RoleMapping mapping, List<? extends EObject>... paths) {
		List<List<? extends EObject>> sortedPaths = ModelUtil.sortPathsBySize(paths);
		if (sortedPaths.size() == 1) {
			List<? extends EObject> path = sortedPaths.get(0);
			for (EObject object : path) {
				EList<Role> roles = mapping.getMappedRolesForEObject(object);
				if (roles.contains(role)) {
					return object;
				}
			}
			return null;
		}
		for (int i = 0; i < sortedPaths.size(); i++) {
			List<? extends EObject> path = sortedPaths.get(i);
			for (EObject eObject : path) {
				boolean found = true;
				for (int j = i + 1; j < sortedPaths.size(); j++) {
					List<? extends EObject> nextPath = sortedPaths.get(j);
					if (!nextPath.contains(eObject)) {
						found = false;
					} else {
						EList<Role> roles = mapping.getMappedRolesForEObject(eObject);
						if (!roles.contains(role)) {
							found = false;
						}
					}
					if (!found) {
						break;
					}
				}
				if (found) {
					return eObject;
				}
			}
		}
		return null;
	}
	
	public static <T extends EObject> T getFirstObjectForRole(String roleName,
			Class<T> type, Map<Role, List<EObject>> roleRuntimeInstanceMap) {
		List<T> objects = getObjectsForRole(roleName, type,
				roleRuntimeInstanceMap);

		if (objects == null || objects.isEmpty()) {
			return null;
		}

		return objects.get(0);
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> getObjectsForRole(String roleName, Class<T> type, Map<Role, List<EObject>> roleRuntimeInstanceMap) {
		Set<Role> roles = roleRuntimeInstanceMap.keySet();
		List<T> typedObjects = new ArrayList<T>();

		for (Role role : roles) {
			if (role.getName().equals(roleName)) {
				List<EObject> objects = roleRuntimeInstanceMap.get(role);

				for (EObject object : objects) {
					// Inverse of instanceof on classes.
					if (type.isAssignableFrom(object.getClass())) {
						typedObjects.add((T) object);
					} else {
						System.out.println("WARNING: Discarding object "
								+ object + " for role \"" + roleName
								+ "\" because it has illegal type \""
								+ object.getClass().getSimpleName()
								+ "\" (expected \"" + type.getSimpleName()
								+ "\")");
					}
				}
			}
		}

		return typedObjects;
	}
}
