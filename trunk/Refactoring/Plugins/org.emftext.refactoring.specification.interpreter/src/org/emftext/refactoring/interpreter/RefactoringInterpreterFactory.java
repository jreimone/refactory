/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.emf.common.util.URI;
import org.emftext.refactoring.interpreter.internal.RefactoringInterpreterFactoryImpl;


/**
 * Interface for RefactoringInterpreter Factories.
 * 
 * @author Jan Reimann
 *
 */
public interface RefactoringInterpreterFactory {

	public static final RefactoringInterpreterFactory eINSTANCE = new RefactoringInterpreterFactoryImpl();
	
	/**
	 * Returns the RefactoringInterpreter for the given modelURI determined by its metamodel.
	 * 
	 * @param modelURI the URI of the model to be refactored
	 * @return the RefactoringInterpreter corresponding to the metamodel of the given model
	 */
	public IRefactoringInterpreter getRefactoringInterpreter(URI modelURI);
}
