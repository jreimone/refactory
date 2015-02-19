/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.analysis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver;
import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage;
import org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

public class SourceTargetBindingSourceReferenceResolver implements IRefcompReferenceResolver<SourceTargetBinding, Role> {
	
	public void resolve(String identifier, SourceTargetBinding container, EReference reference, int position, boolean resolveFuzzy, final IRefcompReferenceResolveResult<Role> result) {
		RoleModel sourceRoleModel = container.getSourceRoleModel();
		if(sourceRoleModel == null){
			BoundRoleMapping boundRoleMapping = (BoundRoleMapping) container.eContainer();
			EStructuralFeature containingFeature = boundRoleMapping.eContainingFeature();
			RoleMapping previousRoleMapping = null;
			if(containingFeature.equals(RefactoringcompositionPackage.Literals.COMPOSITE_ROLE_MAPPING__SEQUENCE)){
				CompositeRoleMapping compositeRoleMapping = getCompositeRoleMapping(container, result);
				previousRoleMapping = compositeRoleMapping.getFirst();
			} else {
				BoundRoleMapping previousMapping = boundRoleMapping.getPreviousMapping();
				previousRoleMapping = previousMapping.getRoleMapping();
			}
			sourceRoleModel = previousRoleMapping.getMappedRoleModel();
		}
		if(sourceRoleModel == null){
			result.setErrorMessage("Couldn't detect the source role model");
			return;
		} else {
			container.setSourceRoleModel(sourceRoleModel);
		}
		List<Role> roles = sourceRoleModel.getRoles();
		if(resolveFuzzy){
			for (Role role : roles) {
				result.addMapping(role.getName(), role);
			}
			return;
		}
		for (Role role : roles) {
			if(role.getName().equals(identifier)){
				result.addMapping(identifier, role);
				return;
			}
		}
		result.setErrorMessage("Role model '" + sourceRoleModel.getName() + "' has no role '" + identifier + "'");
	}
	
	public String deResolve(Role element, SourceTargetBinding container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
	private CompositeRoleMapping getCompositeRoleMapping(SourceTargetBinding container, IRefcompReferenceResolveResult<Role> result) {
		EObject parent = container.eContainer();
		while(parent != null && !(parent instanceof CompositeRoleMapping)){
			parent = parent.eContainer();
		}
		if(parent == null || !(parent instanceof CompositeRoleMapping)){
			result.setErrorMessage("Could not detect parent CompositeRoleMapping");
		}
		CompositeRoleMapping composite = (CompositeRoleMapping) parent;
		return composite;
	}
}
