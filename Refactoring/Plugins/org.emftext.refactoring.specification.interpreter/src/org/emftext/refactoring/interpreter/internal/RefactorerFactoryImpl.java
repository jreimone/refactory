/**
 * 
 */
package org.emftext.refactoring.interpreter.internal;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.interpreter.IValueProviderFactory;
import org.emftext.refactoring.interpreter.RefactorerFactory;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.util.RegistryUtil;

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
		Map<String, RoleMapping> roleMapping = registry.getRoleMappingsForUri(mmUri);
		if(roleMapping == null){
			return null;
		}
		RegistryUtil.log("created Refactorer for " + resource, IStatus.INFO);
		IRefactorer refactorer = new Refactorer(resource, roleMapping);
		System.out.println(resource);
//		refactorer.setValueProviderFactory(factory)
		return refactorer;
	}
	
	private void printResource(Resource resource){
		
	}
}
