/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.analysis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
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

public class SourceTargetBindingTargetReferenceResolver implements IRefcompReferenceResolver<SourceTargetBinding, Role> {
	
	public void resolve(String identifier, SourceTargetBinding container, EReference reference, int position, boolean resolveFuzzy, final IRefcompReferenceResolveResult<Role> result) {
		RoleModel targetRoleModel = container.getTargetRoleModel();
		RoleMapping targetRoleMapping = null;
		BoundRoleMapping boundRoleMapping = (BoundRoleMapping) container.eContainer();
		if(targetRoleModel == null){
			targetRoleMapping = boundRoleMapping.getRoleMapping();
			targetRoleModel = targetRoleMapping.getMappedRoleModel();
		}
		if(targetRoleModel == null){
			result.setErrorMessage("Couldn't detect the source role model");
			return;
		} else {
			container.setTargetRoleModel(targetRoleModel);
		}
		List<Role> roles = targetRoleModel.getRoles();
		if(resolveFuzzy){
			for (Role role : roles) {
				result.addMapping(role.getName(), role);
			}
			return;
		}
		// now check type compatibility
		RoleMapping sourceRoleMapping = getSourceRoleMapping(boundRoleMapping, container, result);
		targetRoleMapping = boundRoleMapping.getRoleMapping();
		Role sourceRole = container.getSource();
		EClass sourceMetaclass = sourceRoleMapping.getEClassForRole(sourceRole);
		for (Role targetRole : roles) {
			if(targetRole.getName().equals(identifier)){
				EClass targetMetaclass = targetRoleMapping.getEClassForRole(targetRole);
				if(!targetMetaclass.isSuperTypeOf(sourceMetaclass)){
					result.setErrorMessage("Roles could be found but the mapped metaclasses are not compatible: " + sourceMetaclass.getName() + " -!-> " + targetMetaclass.getName());
					return;
				}
				result.addMapping(identifier, targetRole);
				return;
			}
		}
		result.setErrorMessage("Role model '" + targetRoleModel.getName() + "' has no role '" + identifier + "'");
	}
	
	private RoleMapping getSourceRoleMapping(BoundRoleMapping boundRoleMapping, SourceTargetBinding container, IRefcompReferenceResolveResult<Role> result){
		EStructuralFeature containingFeature = boundRoleMapping.eContainingFeature();
		RoleMapping previousRoleMapping = null;
		if(containingFeature.equals(RefactoringcompositionPackage.Literals.COMPOSITE_ROLE_MAPPING__SEQUENCE)){
			CompositeRoleMapping compositeRoleMapping = getCompositeRoleMapping(container, result);
			previousRoleMapping = compositeRoleMapping.getFirst();
		} else {
			BoundRoleMapping previousMapping = boundRoleMapping.getPreviousMapping();
			previousRoleMapping = previousMapping.getRoleMapping();
		}
		return previousRoleMapping;
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
