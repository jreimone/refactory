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
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class RoleMappingModelTargetMetamodelReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.RoleMappingModel, org.eclipse.emf.ecore.EPackage> {

	public void resolve(java.lang.String identifier
			, org.emftext.language.refactoring.rolemapping.RoleMappingModel container
			, org.eclipse.emf.ecore.EReference reference
			, int position, boolean resolveFuzzy
			, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		Registry registry = EPackage.Registry.INSTANCE;
		Set<String> uris = registry.keySet();
		// we need to copy the set of URIs, because this set changes
		// when calling getEPackage(), which throws a ConcurrentModificationException
		// when the URI set is accessed.
		Set<String> uriSetCopy = new LinkedHashSet<String>();
		uriSetCopy.addAll(uris);
		if(!resolveFuzzy){
			try {
				// 1. look into the registry
				EPackage metamodel = registry.getEPackage(identifier);
				// 2. if not found, look if it's a resolvable URI  
				if(metamodel == null){
					URI uri = URI.createURI(identifier);
					ResourceSet rs = new ResourceSetImpl();
					Resource resource = rs.getResource(uri, true);
					if(resource != null){
						EObject model = resource.getContents().get(0);
						if(model != null && model instanceof EPackage){
							metamodel = (EPackage) model;
						}
					}
				}
				if(metamodel != null){
					result.addMapping(identifier, metamodel);
				} else {
					result.setErrorMessage("Metamodel '" + identifier + "' couldn't be found");
				}
			} catch (Exception e) {
				// sometimes loading EPackages from the registry causes exceptions
				// if meta models are not registered correctly. we simple ignore
				// those.
			}
		} else {
			for (String uri : uriSetCopy) {
				try {
					result.addMapping(uri, registry.getEPackage(uri));
				} catch (Exception e) {
					// sometimes loading EPackages from the registry causes exceptions
					// if meta models are not registered correctly. we simple ignore
					// those.
				}
			}
		}
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EPackage element, org.emftext.language.refactoring.rolemapping.RoleMappingModel container, org.eclipse.emf.ecore.EReference reference) {
		Registry registry = EPackage.Registry.INSTANCE;
		if(registry.containsKey(element.getNsURI())){
			return element.getNsURI();
		}
		return element.eResource().getURI().toPlatformString(true);
	}

	public void setOptions(java.util.Map<?,?> options) {
	}
}
