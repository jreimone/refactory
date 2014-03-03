package org.corefactoring.modelelementmapper;

import org.ontomore.util.Ecore2OWLDirection;
import org.ontomore.util.OWL2EcoreDirection;

/**
 * Registers all known ModelElementMapper to the ModelElementMapperRegistry.
 * This class can be extended by any registration mechanism, like a registration
 * over Extension Point.
 * 
 * @author Erik Tittel
 */
public class ModelElementInitializer {

	public static void registerModelElementMapper() {
		ModelElementMapperRegistry registry = ModelElementMapperRegistry.INSTANCE;
		registry.registerElementMapper(new Ecore2OWLDirection(), new Ecore2OWLElementMapper());
		registry.registerElementMapper(new OWL2EcoreDirection(), new OWL2EcoreElementMapper());
	}
}
