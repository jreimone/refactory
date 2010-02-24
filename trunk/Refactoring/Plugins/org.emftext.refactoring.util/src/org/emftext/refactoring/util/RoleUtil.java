/**
 * 
 */
package org.emftext.refactoring.util;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.roles.Role;

/**
 * Utility functions for models having to do with roles.
 * 
 * @author Jan Reimann
 *
 */
public class RoleUtil {

	/**
	 * Given a list of objects this method returns all roles which are present in this object list
	 * depending on the given mapping.
	 * 
	 * @param objects
	 * @param mapping
	 */
	public static Set<Role> getAppliedRoles(EList<EObject> objects, Mapping mapping){
		Set<Role> appliedRoleSet = new LinkedHashSet<Role>();
		if(objects == null){
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
	 * @param selection the selected objetcs for which the mappings will be compared to the present roles
	 * @param roleMapping
	 * @param minEquality
	 * @return
	 */
	public static List<Mapping> getPossibleMappingsForSelection(EList<EObject> selection, RoleMappingModel roleMapping, double minEquality){
		List<Mapping> possibleMappings = new LinkedList<Mapping>();
		EList<Mapping> mappings = roleMapping.getMappings();
		for (Mapping mapping : mappings) {
			double equality = getProcentualEquality(selection, mapping);
			if(equality >= minEquality){
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
	public static double getProcentualEquality(EList<EObject> objects, Mapping mapping){
		Collection<Role> allMappedRoles = getAllMappedRoles(mapping);
		Collection<Role> appliedRoles = getAppliedRoles(objects, mapping);
		Collection<Role> matchedRoles = new LinkedList<Role>();
		for (Role appliedRole : appliedRoles) {
			if(allMappedRoles.contains(appliedRole)){
				matchedRoles.add(appliedRole);
			}
		}
		appliedRoles.removeAll(matchedRoles);
		allMappedRoles.removeAll(matchedRoles);
		if(appliedRoles.size() == 0 && allMappedRoles.size() == 0){
			return 1.0;
		}
		double result = 1.0 - ((allMappedRoles.size() - matchedRoles.size()) / allMappedRoles.size());
		return result;
	}
	
	/**
	 * Returns all roles mapped in the given mapping.
	 * 
	 * @param mapping
	 * @return
	 */
	public static List<Role> getAllMappedRoles(Mapping mapping){
		EcoreUtil.resolveAll(mapping.getMappedRoleModel());
		return mapping.getAllMappedRoles();
	}
}
