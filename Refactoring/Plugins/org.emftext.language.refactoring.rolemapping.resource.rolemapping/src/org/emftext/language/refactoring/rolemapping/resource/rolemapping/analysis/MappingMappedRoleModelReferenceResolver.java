/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.roles.RoleModel;

public class MappingMappedRoleModelReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.Mapping, org.emftext.language.refactoring.roles.RoleModel> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.Mapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.emftext.language.refactoring.roles.RoleModel> result) {
		URI uri = URI.createURI(identifier);
		ResourceSet resourceSet = container.eResource().getResourceSet();
		Resource resource = resourceSet.createResource(uri);
		try {
			resource.load(null);
		} catch (IOException e) {
			result.setErrorMessage("Can't load role model: " + e.getMessage());
			return;
		}
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof RoleModel) {
				result.addMapping(identifier, (RoleModel) eObject); 
				EcoreUtil.resolveAll(eObject);
			} else {
				result.setErrorMessage(identifier + " is not a valid Role Model");
			}
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.RoleModel element, org.emftext.language.refactoring.rolemapping.Mapping container, org.eclipse.emf.ecore.EReference reference) {
		return EcoreUtil.getURI(element).toString(); 
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}

}
