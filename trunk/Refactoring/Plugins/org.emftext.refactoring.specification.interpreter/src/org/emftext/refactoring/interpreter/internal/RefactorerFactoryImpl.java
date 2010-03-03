/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

/**
 * @author Jan Reimann
 *
 */
public class RefactorerFactoryImpl implements RefactorerFactory {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.RefactoringInterpreterFactory#getRefactoringInterpreter(org.eclipse.emf.common.util.URI)
	 */
	public IRefactorer getRefactorer(Resource resource) {
		IRoleMappingRegistry registry = IRoleMappingRegistry.INSTANCE;
		EObject root = resource.getContents().get(0);
		String mmUri = root.eClass().getEPackage().getNsURI();
		RoleMappingModel roleMapping = registry.getRoleMappingForUri(mmUri);
		if(roleMapping == null){
			return null;
		}
		return new Refactorer(root, roleMapping);
	}
}
