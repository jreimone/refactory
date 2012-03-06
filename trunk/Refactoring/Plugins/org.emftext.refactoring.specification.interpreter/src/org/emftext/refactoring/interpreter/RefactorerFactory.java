/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
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
	 * Returns the Refactorer for the given <code>resource</code> (determined by its metamodel)
	 * and the given <code>roleMapping</code>.
	 * 
	 * @param resource the resource of the model to be refactored
	 * @param roleMapping 
	 * @return the RefactoringInterpreter corresponding to the metamodel of the given model
	 */
	public IRefactorer getRefactorer(Resource resource, RoleMapping roleMapping);
	
//	public IRefactorer getRefactorer(Resource resource, IndexConnector indexConnector);
}
