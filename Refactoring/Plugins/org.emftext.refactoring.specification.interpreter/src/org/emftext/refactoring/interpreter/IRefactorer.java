/**
 * 
 */
package org.emftext.refactoring.interpreter;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;

/**
 * Interface for Refactorer.
 * 
 * @author Jan Reimann
 *
 */
public interface IRefactorer {

	/**
	 * Sets the input for the RefactoringInterpreter by passing the selected EObjects.
	 * The selection can come for example from selected nodes in a EMF generated tree editor. 
	 * 
	 * @param selectedElements the selected elements
	 */
	public void setInput(EList<EObject> selectedElements);
	
	/**
	 * Infers over the mapped roles if the elements set with {@link #setInput(EList)} and determines 
	 * by the completeness of the applied roles in different mappings if they are invokable.
	 * 
	 * @return a list of possible RefactoringSpecifications
	 */
	public List<RefactoringSpecification> getPossibleRefactorings();
	
	/**
	 * Invokes the specified RefactoringSpecification on the model set in {@link #setInput(EList)}.
	 * 
	 * @param refSpec the refactoring to invoke
	 * @param copy specify of the refactoring should be done on a copy of the original model - 
	 * if set to <code>true</code> the original model stays untouched
	 * @return the refactored model
	 */
	public EObject refactor(RefactoringSpecification refSpec, boolean copy);
}
