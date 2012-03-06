/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * @author Jan Reimann
 *
 */
public class RefactorerFactoryImpl implements RefactorerFactory {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.RefactoringInterpreterFactory#getRefactoringInterpreter(org.eclipse.emf.common.util.URI)
	 */
	public IRefactorer getRefactorer(Resource resource, RoleMapping roleMapping) {
		IRefactorer refactorer = new Refactorer(resource, roleMapping);
		RegistryUtil.log("created Refactorer for " + resource, IStatus.INFO);
		System.out.println(resource);
		return refactorer;
	}
}
