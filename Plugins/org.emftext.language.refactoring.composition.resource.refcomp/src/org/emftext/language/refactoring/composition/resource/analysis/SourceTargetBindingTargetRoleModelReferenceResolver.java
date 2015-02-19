/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver;
import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding;
import org.emftext.language.refactoring.roles.RoleModel;

public class SourceTargetBindingTargetRoleModelReferenceResolver implements IRefcompReferenceResolver<SourceTargetBinding, RoleModel> {
	
	public void resolve(String identifier, SourceTargetBinding container, EReference reference, int position, boolean resolveFuzzy, final IRefcompReferenceResolveResult<RoleModel> result) {
		EObject parent = container.eContainer();
		if(parent instanceof BoundRoleMapping){
			BoundRoleMapping boundRoleMapping = (BoundRoleMapping) parent;
			RoleModel mappedRoleModel = boundRoleMapping.getRoleMapping().getMappedRoleModel();
			EcoreUtil.resolveAll(mappedRoleModel);
			result.addMapping(identifier, mappedRoleModel);
		} else {
			result.setErrorMessage("Something strange happened here");
			return;
		}
	}
	
	public String deResolve(RoleModel element, SourceTargetBinding container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
