/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.Variable;

/**
 * The context for the RefactoringInterpreter
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreterContext {

	EList<Variable> variables;
	
	/**
	 * Initializes the variables in the context as they are declared in the given RefactoringSpecification. 
	 * @param refSpec
	 */
	public void initializeVariables(RefactoringSpecification refSpec){
		
	}
}
