/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.indexconnector.IndexConnector;
import org.emftext.refactoring.indexconnector.IndexConnectorFactory;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.RefactorerFactory;

/**
 * @author Jan Reimann
 *
 */
public class RefactorerFactoryImpl implements RefactorerFactory {

	/* (non-Javadoc)
	 * @see org.emftext.refactoring.interpreter.RefactoringInterpreterFactory#getRefactoringInterpreter(org.eclipse.emf.common.util.URI)
	 */
	public IRefactorer getRefactorer(Resource resource) {
		IndexConnectorFactory factory = IndexConnectorFactory.defaultINSTANCE;
		IndexConnector indexConnector = factory.getIndexConnector();
		EObject root = resource.getContents().get(0);
		String mmUri = root.eClass().getEPackage().getNsURI();
		RoleMappingModel roleMapping = indexConnector.getRoleMapping(mmUri);
		return new Refactorer(root, roleMapping);
	}

}
