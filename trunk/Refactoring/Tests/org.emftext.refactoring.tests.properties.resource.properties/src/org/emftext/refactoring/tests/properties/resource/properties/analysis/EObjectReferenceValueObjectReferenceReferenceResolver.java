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
package org.emftext.refactoring.tests.properties.resource.properties.analysis;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emftext.refactoring.tests.properties.EObjectReferenceValue;
import org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolveResult;
import org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver;

public class EObjectReferenceValueObjectReferenceReferenceResolver implements IPropertiesReferenceResolver<EObjectReferenceValue, EObject> {

	public void resolve(String identifier, EObjectReferenceValue container, EReference reference, int position, boolean resolveFuzzy, final IPropertiesReferenceResolveResult<EObject> result) {
		try{
			URI uri = URI.createURI(identifier);
			ResourceSet resourceSet = container.eResource().getResourceSet();
			Resource resource = resourceSet.getResource(uri, true);
			if (resource == null ) {
				result.setErrorMessage(identifier + " is not a valid reference to an EObject");
				return;
			}
			EList<EObject> contents = resource.getContents();
			if(contents == null || contents.size() == 0){
				result.setErrorMessage(resource + " doesn't contain an EObject");
				return;
			}
			result.addMapping(identifier, contents.get(0));
		} catch (Exception e) {
			result.setErrorMessage(identifier + " is not a valid reference to an EObject");
		}
	}

	public String deResolve(EObject element, EObjectReferenceValue container, EReference reference) {
		return element.eResource().getURI().toPlatformString(true);
//		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
