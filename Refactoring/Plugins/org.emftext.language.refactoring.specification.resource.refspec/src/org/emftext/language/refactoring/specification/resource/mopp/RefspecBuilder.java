/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.refactoring.specification.resource.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.specification.resource.IRefspecBuilder;
import org.emftext.language.refactoring.specification.resource.RefspecEProblemType;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistry;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;

public class RefspecBuilder implements IRefspecBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
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
	
	public IStatus build(RefspecResource resource, IProgressMonitor monitor) {
		RefactoringSpecification model = (RefactoringSpecification) resource.getContents().get(0);
		try {
			if((resource.getErrors() == null || resource.getErrors().size() == 0)){
				IRefactoringSpecificationRegistry.INSTANCE.registerRefSpec(model);
				resource.addWarning("This Refactoring Specification was only registered temporarily.\nYou should consider to register it as extension.", RefspecEProblemType.BUILDER_ERROR, model);
			}
		} catch (RefSpecAlreadyRegisteredException e) {
			IRefactoringSpecificationRegistry.INSTANCE.updateRefSpec(model);
			resource.addWarning("This Refactoring Specification was only registered temporarily.\nYou should consider to register it as extension.", RefspecEProblemType.BUILDER_ERROR, model);
		}
		return Status.OK_STATUS;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
