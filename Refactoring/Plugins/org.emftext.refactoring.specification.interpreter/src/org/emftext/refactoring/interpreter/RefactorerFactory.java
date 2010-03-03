/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.refactoring.interpreter.internal.RefactorerFactoryImpl;


/**
 * Interface for RefactoringInterpreter Factories.
 * 
 * @author Jan Reimann
 *
 */
public interface RefactorerFactory {

	public static final RefactorerFactory eINSTANCE = new RefactorerFactoryImpl();
	
	
	/**
	 * Returns the Refactorer for the given resource determined by its metamodel.
	 * 
	 * @param resource the resource of the model to be refactored
	 * @return the RefactoringInterpreter corresponding to the metamodel of the given model
	 */
	public IRefactorer getRefactorer(Resource resource);
	
//	public IRefactorer getRefactorer(Resource resource, IndexConnector indexConnector);
}
