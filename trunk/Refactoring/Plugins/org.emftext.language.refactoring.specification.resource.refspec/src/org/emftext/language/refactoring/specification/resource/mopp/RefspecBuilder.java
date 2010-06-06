/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.mopp;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;

public class RefspecBuilder implements org.emftext.language.refactoring.specification.resource.IRefspecBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource != null && (resource.getErrors() == null || resource.getErrors().size() == 0)){
			EObject root = resource.getContents().get(0);
			if(root instanceof RefactoringSpecification){
				RefactoringSpecification model = (RefactoringSpecification) root;
				RoleModel roleModel = model.getUsedRoleModel();
				RefactoringSpecification registeredModel = IRefactoringSpecificationRegistry.INSTANCE.getRefSpec(roleModel);
				if(registeredModel == null){
					return true;
				} else {
					if(registeredModel.eResource().getURI().equals(resource.getURI())){
						return true;
					}
				}
			}
		}
		return false;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.refactoring.specification.resource.mopp.RefspecResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		RefactoringSpecification model = (RefactoringSpecification) resource.getContents().get(0);
		try {
			if((resource.getErrors() == null || resource.getErrors().size() == 0)){
				IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(model);
				resource.addWarning("This Refactoring Specification was only registered temporarily.\nYou should consider to register it as extension.", model);
			}
		} catch (RefSpecAlreadyRegisteredException e) {
			IRefactoringSpecificationRegistry.INSTANCE.updateRefSpec(model);
			resource.addWarning("This Refactoring Specification was only registered temporarily.\nYou should consider to register it as extension.", model);
		}
		return Status.OK_STATUS;
	}
	
}
