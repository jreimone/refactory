/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.composition.resource.analysis;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolveResult;
import org.emftext.language.refactoring.composition.resource.IRefcompReferenceResolver;
import org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

public class CompositeRoleMappingFirstReferenceResolver extends AbstractRoleMappingResolver implements IRefcompReferenceResolver<CompositeRoleMapping, RoleMapping> {
	
	private CompositeRoleMapping container;

	protected EPackage getMetamodel() {
		EPackage targetMetamodel = container.getTargetMetamodel();
		return targetMetamodel;
	}

	@Override
	public void resolve(String identifier, CompositeRoleMapping container, EReference reference, int position, boolean resolveFuzzy, IRefcompReferenceResolveResult<RoleMapping> result) {
		this.container = container;
		resolve(identifier, resolveFuzzy, result);
	}

	@Override
	public String deResolve(RoleMapping element, CompositeRoleMapping container, EReference reference) {
		return deResolve(element);
	}
}
