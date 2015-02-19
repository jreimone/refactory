package org.emftext.language.refactoring.composition.resource.analysis;

/**
 * <copyright>
 * </copyright>
 *
 * 
 */

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;

public class CompositeRoleMappingTargetMetamodelReferenceResolver implements IRefcompReferenceResolver<CompositeRoleMapping, EPackage> {
	
	public void resolve(String identifier, CompositeRoleMapping container, EReference reference, int position, boolean resolveFuzzy, final IRefcompReferenceResolveResult<EPackage> result) {
		Registry registry = EPackage.Registry.INSTANCE;
		// we need to copy the set of URIs, because this set changes
		// when calling getEPackage(), which throws a ConcurrentModificationException
		// when the URI set is accessed.
		Set<String> uriSetCopy = new HashSet<String>(registry.keySet());
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
	
	public String deResolve(EPackage element, CompositeRoleMapping container, EReference reference) {
		return element.getNsURI();
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
