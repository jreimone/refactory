package org.corefactoring.rolemappingregistry;

import org.ontomore.util.Ecore2OWLDirection;
import org.ontomore.util.OWL2EcoreDirection;

/**
 * Registers all known RoleMappingMapper to the RoleMappingRegistry. This class
 * can be extended by any registration mechanism, like a registration over
 * Extension Point.
 * 
 * @author Erik Tittel
 */
public class RoleMappingInitializer {

	public static void registerRoleMappingMapper() {
		RoleMappingRegistry registry = RoleMappingRegistry.INSTANCE;
		registry.registerRoleMappingMapper(new OWL2EcoreDirection(),
				new OWL2EcoreRoleMappingMapper());
		registry.registerRoleMappingMapper(new Ecore2OWLDirection(),
				new Ecore2OWLRoleMappingMapper());
	}

}
