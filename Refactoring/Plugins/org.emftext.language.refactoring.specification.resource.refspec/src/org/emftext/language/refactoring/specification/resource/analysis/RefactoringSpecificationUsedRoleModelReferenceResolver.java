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

	private org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, org.emftext.language.refactoring.roles.RoleModel> delegate = new org.emftext.language.refactoring.specification.resource.analysis.RefspecDefaultResolverDelegate<org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification, org.emftext.language.refactoring.roles.RoleModel>();

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<org.emftext.language.refactoring.roles.RoleModel> result) {
		IRoleModelRegistry registry = IRoleModelRegistry.INSTANCE;
		RoleModel model = registry.getRoleModelByName(identifier);
		if(model != null){
			result.addMapping(identifier, model);
			EcoreUtil.resolveAll(model);
		} else {
			URI uri = URI.createURI(identifier);
			ResourceSet resourceSet = container.eResource().getResourceSet();
			Resource resource = resourceSet.getResource(uri, true);
			if (resource == null ) {
				result.setErrorMessage("Can't load role model from " + identifier);
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
	}

	public java.lang.String deResolve(org.emftext.language.refactoring.roles.RoleModel element, org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification container, org.eclipse.emf.ecore.EReference reference) {
		return EcoreUtil.getURI(element).toString(); 
	}

	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}

}
