/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.coed.resource.coed.mopp;


/**
 * This exception is used to terminate generated parsers. Depending on the state
 * of a stop flag the parser throws this exception to break the control flow and
 * allow users of the parser to stop parsing.
 */
public class CoedTerminateParsingException extends RuntimeException {
	
	private static final long serialVersionUID = 117529647036954724L;
	
}
