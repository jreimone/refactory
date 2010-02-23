/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.Variable;

/**
 * The context for the RefactoringInterpreter
 * 
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreterContext {

	private EList<Variable> variables;
	private EObject model;
	private EList<EObject> selection;
	
	protected void setInitialContext(EObject model, EList<EObject> selection){
		this.model = model;
		this.selection = selection;
	}
	
	/**
	 * Initializes the variables in the context as they are declared in the given RefactoringSpecification. 
	 * @param refSpec
	 */
	public void initializeVariables(RefactoringSpecification refSpec){
		// TODO init variables to instances
	}

	/**
	 * @return the model
	 */
	public EObject getModel() {
		return model;
	}
}
