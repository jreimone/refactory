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
package org.emftext.refactoring.tests.properties.resource.testproperties.analysis;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class EObjectReferenceValueObjectReferenceReferenceResolver implements org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolver<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultResolverDelegate<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.refactoring.tests.properties.resource.testproperties.analysis.TestpropertiesDefaultResolverDelegate<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, org.emftext.refactoring.tests.properties.EObjectReferenceValue container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.refactoring.tests.properties.resource.testproperties.ITestpropertiesReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		try{
			URI uri = URI.createURI(identifier);
			ResourceSet resourceSet = container.eResource().getResourceSet();
			Resource resource = resourceSet.getResource(uri, true);
			if (resource == null ) {
				result.setErrorMessage(identifier + " is not a valid reference to an EObject");
				return;
			}
			List<EObject> contents = resource.getContents();
			if(contents == null || contents.size() == 0){
				result.setErrorMessage(resource + " doesn't contain an EObject");
				return;
			}
			result.addMapping(identifier, contents.get(0));
		} catch (Exception e) {
			result.setErrorMessage(identifier + " is not a valid reference to an EObject");
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.refactoring.tests.properties.EObjectReferenceValue container, org.eclipse.emf.ecore.EReference reference) {
		return element.eResource().getURI().toPlatformString(true);
//		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
