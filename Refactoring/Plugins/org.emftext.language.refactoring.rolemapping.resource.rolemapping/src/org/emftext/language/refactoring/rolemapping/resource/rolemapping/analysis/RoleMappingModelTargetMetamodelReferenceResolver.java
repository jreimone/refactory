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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;

public class RoleMappingModelTargetMetamodelReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.RoleMappingModel, org.eclipse.emf.ecore.EPackage> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.RoleMappingModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		Registry registry = EPackage.Registry.INSTANCE;
		Set<String> uris = registry.keySet();
		// we need to copy the set of URIs, because this set changes
		// when calling getEPackage(), which throws a ConcurrentModificationException
		// when the URI set is accessed.
		Set<String> uriSetCopy = new LinkedHashSet<String>();
		uriSetCopy.addAll(uris);
		for (String uri : uriSetCopy) {
			if (uri.equals(identifier) || resolveFuzzy) {
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
		return element.getNsURI();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
	}
}
