package org.corefactoring.rolemappingregistry;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.ontomore.util.Direction;

/**
 * Provides the corresponding RoleMapping depending on the direction. The
 * concrete mapper for that direction has to be registered in advance.
 * 
 * @author Erik Tittel
 */
public interface RoleMappingRegistry {

	public static RoleMappingRegistry INSTANCE = RoleMappingRegistryImpl.getInstance();

	/**
	 * Depending on the given direction the appropriate RoleMappingRegistry is
	 * asked for the corresponding RoleMapping.
	 */
	public RoleMapping getCorrespondingRoleMappingByDirection(RoleMapping roleMapping,
			EObject inputElement, Direction direction);

	/**
	 * Registers a mapper for RoleMappings for the given direction (e. g. from
	 * OWL-RoleMappings to Ecore-RoleMappings). Fulfils the contract of a
	 * Map.put().
	 */
	public RoleMappingMapper registerRoleMappingMapper(Direction direction,
			RoleMappingMapper roleMappingMapper);

}