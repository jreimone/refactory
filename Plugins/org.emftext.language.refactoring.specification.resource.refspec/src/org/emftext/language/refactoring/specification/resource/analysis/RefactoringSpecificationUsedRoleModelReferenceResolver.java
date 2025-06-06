/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;

public class RefactoringSpecificationUsedRoleModelReferenceResolver implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, org.emftext.language.refactoring.roles.RoleModel> {

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<org.emftext.language.refactoring.roles.RoleModel> result) {
		IRoleModelRegistry registry = IRoleModelRegistry.INSTANCE;
		if (resolveFuzzy) {
			for (RoleModel roleModel : registry.getAllRegisteredRoleModels()) {
				result.addMapping(roleModel.getName(), roleModel);
			}
			return;
		}
		RoleModel model = registry.getRoleModelByName(identifier);
		if(model != null){
			result.addMapping(identifier, model);
			EcoreUtil.resolveAll(model);
		} else {
			URI uri = URI.createURI(identifier);
			ResourceSet resourceSet = container.eResource().getResourceSet();
			Resource resource = null;
			try {
				resource = resourceSet.getResource(uri, true);
			} catch (Exception e) {
				if(!resolveFuzzy){
					result.setErrorMessage("Can't load role model from " + identifier);
				}
				return;
			}
			if (resource == null && !resolveFuzzy) {
				result.setErrorMessage("Can't load role model from " + identifier);
				return;
			}
			EList<EObject> contents = resource.getContents();
			for (EObject eObject : contents) {
				if (eObject instanceof RoleModel) {
					String name = ((RoleModel) eObject).getName();
					model = registry.getRoleModelByName(name);
					if(model != null){
						result.addMapping(identifier, model); 
						EcoreUtil.resolveAll(model);
					} else {
						result.addMapping(identifier, (RoleModel) eObject); 
						EcoreUtil.resolveAll(eObject);
					}
				} else {
					result.setErrorMessage(identifier + " is not a valid Role Model");
				}
			}
		}
	}

	public java.lang.String deResolve(org.emftext.language.refactoring.roles.RoleModel element, org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification container, org.eclipse.emf.ecore.EReference reference) {
		return EcoreUtil.getURI(element).toString(); 
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
