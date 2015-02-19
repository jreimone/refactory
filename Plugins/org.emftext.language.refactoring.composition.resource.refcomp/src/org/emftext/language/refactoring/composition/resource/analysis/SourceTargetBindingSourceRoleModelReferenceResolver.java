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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver;
import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage;
import org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.RoleModel;

public class SourceTargetBindingSourceRoleModelReferenceResolver implements IRefcompReferenceResolver<SourceTargetBinding, RoleModel> {
	
	private IRefcompReferenceResolveResult<RoleModel> result;
	private SourceTargetBinding container;

	public void resolve(String identifier, SourceTargetBinding container, EReference reference, int position, boolean resolveFuzzy, final IRefcompReferenceResolveResult<RoleModel> result) {
		this.container = container;
		this.result = result;
		EObject parent = container.eContainer();
		if(parent instanceof BoundRoleMapping){
			BoundRoleMapping boundRoleMapping = (BoundRoleMapping) parent;
			EStructuralFeature containingFeature = boundRoleMapping.eContainingFeature();
			RoleMapping previousRoleMapping = null;
			if(containingFeature.equals(RefactoringcompositionPackage.Literals.COMPOSITE_ROLE_MAPPING__SEQUENCE)){
				CompositeRoleMapping compositeRoleMapping = getCompositeRoleMapping();
				previousRoleMapping = compositeRoleMapping.getFirst();
			} else {
				BoundRoleMapping previousMapping = boundRoleMapping.getPreviousMapping();
				previousRoleMapping = previousMapping.getRoleMapping();
			}
			if(previousRoleMapping == null){
				result.setErrorMessage("Couldn't detect the previous role mapping");
				return;
			}
			EcoreUtil.resolveAll(previousRoleMapping);
			result.addMapping(identifier, previousRoleMapping.getMappedRoleModel());
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

	private CompositeRoleMapping getCompositeRoleMapping() {
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
