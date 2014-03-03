package org.ontomore.util;

import static org.ontomore.util.CoRefactoryConstants.ECORE_METAMODEL;
import static org.ontomore.util.CoRefactoryConstants.OWL_METAMODEL;

/**
 * Represents the OWL -> Ecore co-refactoring direction. 
 * 
 * @author Erik Tittel
 */
public class OWL2EcoreDirection extends Direction {

	public OWL2EcoreDirection() {
		super(OWL_METAMODEL, ECORE_METAMODEL);
	}
}
