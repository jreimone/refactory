/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;

/**
 * Interface for RefactoringInterpreter
 * 
 * @author Jan Reimann
 *
 */
public interface IRefactoringInterpreter {

	/**
	 * Initializes a concrete RefactoringInterpreter with a {@link RefactoringSpecification} 
	 * containing the declared steps for the refactoring. Besides that the model being refactored
	 * and the elements serving as input for the refactoring are needed, too.
	 * 
	 * @param refSpec the specification containing the steps of the refactoring
	 * @param model the model being refactored
	 */
	public void initialize(RefactoringSpecification refSpec, EObject model, EList<EObject> selection);
	
	/**
	 * Invokes the refactoring process on the model and with the steps determined in {@link IRefactoringInterpreter#initialize(RefactoringSpecification, EObject)}.
	 * @param copy flag to decide whether the refactoring should be invoked on a copy of the model
	 * @return returns the refactored model
	 */
	public EObject interprete(boolean copy);
}
