/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.emf.common.util.URI;
import org.emftext.refactoring.interpreter.IRefactoringInterpreter;
import org.emftext.refactoring.interpreter.RefactoringInterpreterFactory;

/**
 * @author Jan Reimann
 *
 */
public class RefactoringInterpreterFactoryImpl implements RefactoringInterpreterFactory {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.RefactoringInterpreterFactory#getRefactoringInterpreter(org.eclipse.emf.common.util.URI)
	 */
	public IRefactoringInterpreter getRefactoringInterpreter(URI modelURI) {
		// TODO distinguish the metamodel from the given model
		return null;
	}

}
