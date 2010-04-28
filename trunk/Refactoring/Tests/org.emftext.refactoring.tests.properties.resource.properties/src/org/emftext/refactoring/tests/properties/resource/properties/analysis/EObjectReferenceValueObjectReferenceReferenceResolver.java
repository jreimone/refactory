/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.refactoring.tests.properties.resource.properties.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class EObjectReferenceValueObjectReferenceReferenceResolver implements org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolver<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject> {

	private org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesDefaultResolverDelegate<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.refactoring.tests.properties.resource.properties.analysis.PropertiesDefaultResolverDelegate<org.emftext.refactoring.tests.properties.EObjectReferenceValue, org.eclipse.emf.ecore.EObject>();

	public void resolve(java.lang.String identifier, org.emftext.refactoring.tests.properties.EObjectReferenceValue container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.refactoring.tests.properties.resource.properties.IPropertiesReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
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

	public java.lang.String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.refactoring.tests.properties.EObjectReferenceValue container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
