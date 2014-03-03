package org.corefactoring.rolemappingregistry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.ontomore.util.Direction;

/**
 * Holds a map of RoleMappingMappers that are used to get the corresponding
 * RoleMapping.
 * 
 * @author Erik Tittel
 */
public class RoleMappingRegistryImpl implements RoleMappingRegistry {

	private static RoleMappingRegistryImpl uniqueInstance = null;
	private Map<Direction, RoleMappingMapper> map;

	private RoleMappingRegistryImpl() {
		map = new HashMap<Direction, RoleMappingMapper>();
	}
	
	public static RoleMappingRegistryImpl getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new RoleMappingRegistryImpl();
		}
		return uniqueInstance;
	}

	public RoleMapping getCorrespondingRoleMappingByDirection(RoleMapping roleMapping,
			EObject inputElement, Direction direction) {
		RoleMappingMapper roleMappingMapper = map.get(direction);
		if (roleMappingMapper == null) {
			throw new RuntimeException(
					"No RoleMappingMapper has been registered for that direction");
		}
		return roleMappingMapper.getCorrespondingRoleMapping(roleMapping, inputElement);
	}

	public RoleMappingMapper registerRoleMappingMapper(Direction direction,
			RoleMappingMapper roleMappingMapper) {
		return map.put(direction, roleMappingMapper);
	}
}
