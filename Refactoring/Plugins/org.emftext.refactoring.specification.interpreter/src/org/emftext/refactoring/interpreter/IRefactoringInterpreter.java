/**
 * 
 */
package org.emftext.refactoring.interpreter;


import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;

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
	 * and the elements serving as input for the refactoring are needed, too. Finally a {@link Mapping} is
	 * obligatory because by the mapping the metaclasses can be determined.
	 * 
	 * @param refSpec the specification containing the steps of the refactoring
	 * @param model the model being refactored
	 * @param roleMapping 
	 * @param mapping 
	 */
	public void initialize(RefactoringSpecification refSpec, EObject model, RoleMappingModel roleMapping, Mapping mapping);
	
	/**
	 * Invokes the refactoring process on the model and with the steps determined in {@link IRefactoringInterpreter#initialize(RefactoringSpecification, EObject)}.
	 * 
	 * @param copy flag to decide whether the refactoring should be invoked on a copy of the model
	 * @return returns the refactored model or <code>null</code> if {@link IRefactoringInterpreter#setMapping(Mapping)} wasn't invoked before
	 */
	public EObject interprete(boolean copy);
	
	/**
	 * Sets the the current selection, for which the appropriate interpreter is to be run, as input.
	 * @param currentSelection
	 */
	public void setInput(List<? extends EObject> currentSelection);
}
