package org.emftext.refactoring.interpreter.exceptions;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;

/**
 * Can be thrown when errors occur while interpreting a {@link RefactoringSpecification}
 * 
 * @author jreimann
 *
 */
public class RefSpecInterpretationException extends Exception {

	public RefSpecInterpretationException(String errorMessage) {
		super(errorMessage);
	}

	private static final long serialVersionUID = 4452402711104435225L;

}
