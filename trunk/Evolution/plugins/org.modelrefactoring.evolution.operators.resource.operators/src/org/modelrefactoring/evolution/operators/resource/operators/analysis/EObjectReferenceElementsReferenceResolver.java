/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.modelrefactoring.evolution.operators.resource.operators.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.modelrefactoring.evolution.operators.EObjectReference;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolveResult;
import org.modelrefactoring.evolution.operators.resource.operators.IOperatorsReferenceResolver;

public class EObjectReferenceElementsReferenceResolver implements IOperatorsReferenceResolver<EObjectReference, EObject> {

//	private OperatorsDefaultResolverDelegate<EObjectReference, EObject> delegate = new OperatorsDefaultResolverDelegate<EObjectReference, EObject>();

	public void resolve(String identifier, EObjectReference container, EReference reference, int position, boolean resolveFuzzy, final IOperatorsReferenceResolveResult<EObject> result) {
		URI uri = URI.createURI(identifier);
		String fragment = null;
		if(uri.hasFragment()){
			fragment = uri.fragment();
			uri = uri.trimFragment();
		}
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(uri, true);
		if(resource != null){
			EObject element = null;
			if(fragment != null){
				element = resource.getEObject(fragment);
			} else {
				element = resource.getContents().get(0);
			}
			if(element != null){
				result.addMapping(identifier, element);
				return;
			}
		}
		result.setErrorMessage("Model element '" + identifier + "' couldn't be found");
	}

	public String deResolve(EObject element, EObjectReference container, EReference reference) {
		URI uri = EcoreUtil.getURI(element);
		return uri.toString();
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}

}
