package org.ontomore.util;

import static org.ontomore.util.CoRefactoryConstants.ECORE_METAMODEL;
import static org.ontomore.util.CoRefactoryConstants.OWL_METAMODEL;

/**
 * Represents the Ecore -> OWL co-refactoring direction. 
 * 
 * @author Erik Tittel
 */
public class Ecore2OWLDirection extends Direction {

	public Ecore2OWLDirection() {
		super(ECORE_METAMODEL, OWL_METAMODEL);
	}
}
