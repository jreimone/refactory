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
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver;

public class RoleMappingModelImportsReferenceResolver implements IRolemappingReferenceResolver<RoleMappingModel, EPackage> {

	public void resolve(String identifier, RoleMappingModel container, EReference reference, int position, boolean resolveFuzzy, final IRolemappingReferenceResolveResult<EPackage> result) {
		EPackage.Registry registry = EPackage.Registry.INSTANCE;
		Set<String> uris = registry.keySet();
		// we need to copy the set of URIs, because this set changes
		// when calling getEPackage(), which throws a ConcurrentModificationException
		// when the URI set is accessed.
		Set<String> uriSetCopy = new LinkedHashSet<String>();
		uriSetCopy.addAll(uris);
		if(resolveFuzzy) {
			for (String uri : uriSetCopy) {
				try {
					result.addMapping(uri, registry.getEPackage(uri));
				} catch (Exception e) {
					// sometimes loading EPackages from the registry causes exceptions
					// if meta models are not registered correctly. we simply ignore
					// those.
				}
			}
			return;
		} else {
			// 1. possibility: Ns URI in Registry
			if(uriSetCopy.contains(identifier)){
				result.addMapping(identifier, registry.getEPackage(identifier));
				return;
			} else {
				// 2. possibility: general URI
				try {
					URI uri = URI.createURI(identifier);
					ResourceSet rs = new ResourceSetImpl();
					Resource resource = rs.getResource(uri, true);
					if(resource != null){
						List<EObject> contents = resource.getContents();
						if(contents != null && contents.size() > 0){
							EObject model = contents.get(0);
							if(model instanceof EPackage){
								EPackage metamodel = (EPackage) model;
								result.addMapping(identifier, metamodel);
								return;
							}
						}
					}
				} catch (Exception e) {
					// just do not try to load the model
				}
			}
		}
		result.setErrorMessage("Import with URI '" + identifier + "' couldn't be resolved");
	}

	public String deResolve(EPackage element, RoleMappingModel container, EReference reference) {
		return element.getNsURI();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}

}
