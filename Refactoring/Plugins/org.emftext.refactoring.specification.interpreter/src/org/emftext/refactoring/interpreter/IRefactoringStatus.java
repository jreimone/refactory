/**
 * 
 */
package org.emftext.refactoring.interpreter;

import org.eclipse.core.runtime.IStatus;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * With this interface a status for refactoring can be encoded. If a step from the {@link RefactoringSpecification}
 * returns a status containing an {@link IRefactoringStatus#ERROR} then the refactoring will be rolled back. The status 
 * type (as for example {@link IRefactoringStatus#OK} is compatible with those from {@link IStatus}.  
 * 
 * @author Jan Reimann
 *
 */
public interface IRefactoringStatus extends IStatus{
	
	/**
	 * Returns the mapping for which the status is produced.
	 * @return
	 */
	public RoleMapping getRoleMapping();
	
	/**
	 * Sets the throwable connected to this status.
	 * 
	 * @param throwable
	 */
	public void setThrowable(Throwable throwable);
	
	/**
	 * Sets the message of this status
	 * @param message
	 */
	public void setMessage(String message);
}
