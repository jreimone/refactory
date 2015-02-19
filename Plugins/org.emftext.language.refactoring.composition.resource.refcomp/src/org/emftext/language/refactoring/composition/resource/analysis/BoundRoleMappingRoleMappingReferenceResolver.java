/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver;
import org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

public class BoundRoleMappingRoleMappingReferenceResolver extends AbstractRoleMappingResolver implements IRefcompReferenceResolver<BoundRoleMapping, RoleMapping> {

	private BoundRoleMapping container;
	private IRefcompReferenceResolveResult<RoleMapping> result;

	@Override
	public void resolve(String identifier, BoundRoleMapping container,
			EReference reference, int position, boolean resolveFuzzy,
			IRefcompReferenceResolveResult<RoleMapping> result) {
		this.container = container;
		this.result = result;
		resolve(identifier, resolveFuzzy, result);
	}

	@Override
	public String deResolve(RoleMapping element, BoundRoleMapping container, EReference reference) {
		return deResolve(element);
	}

	@Override
	protected EPackage getMetamodel() {
		CompositeRoleMapping composite = getCompositeRoleMapping();
		if(composite == null){
			result.setErrorMessage("Could not detect target metamodel");
		}
		return composite.getTargetMetamodel();
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
