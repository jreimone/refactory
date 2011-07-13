package org.emftext.refactoring.registry.rolemapping;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.refactoring.ltk.IModelRefactoringWizardPage;

/**
 * Abstract class implementing basic functionality of {@link IRefactoringPostProcessor IRefactoringPostProcessor}.
 * The main purpose of this class is to ease further development of the IRefactoringPostProcessor interface
 * by providing backwards comatibility. Furthermore, newer versions of concrete post processors do not need to
 * implement the deprecated interface.
 * 
 * @author Christoph Seidl
 */
public class AbstractRefactoringPostProcessor implements IRefactoringPostProcessor {

	//Deprecated
	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	ResourceSet resourceSet, ChangeDescription change) {
		return Status.OK_STATUS;
	}

	public IStatus process(Map<Role, List<EObject>> roleRuntimeInstanceMap,	EObject refactoredModel, ResourceSet resourceSet, ChangeDescription change, 
			RefactoringSpecification refSpec, List<IModelRefactoringWizardPage> customWizardPages, boolean isFakeRun) {
		
		//Provide backwards compatibility for those classes that need it.
		//All others may simply override this method.
		return process(roleRuntimeInstanceMap, resourceSet, change);
	}
}
