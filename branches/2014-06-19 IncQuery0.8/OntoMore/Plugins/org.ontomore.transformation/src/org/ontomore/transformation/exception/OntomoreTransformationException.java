package org.ontomore.transformation.exception;

/**
 * Exception that is thrown, when the transformation from OWL to Ecore could not
 * be completed successfully.
 * 
 * @author Erik Tittel
 * 
 */
public class OntomoreTransformationException extends RuntimeException {

	private static final long serialVersionUID = 8506149024085701107L;

	public OntomoreTransformationException(String message) {
		super(message);
	}
	
}
