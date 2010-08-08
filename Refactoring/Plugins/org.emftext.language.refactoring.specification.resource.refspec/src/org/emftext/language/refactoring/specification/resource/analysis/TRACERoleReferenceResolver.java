/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.specification.resource.util.RefspecEObjectUtil;

public class TRACERoleReferenceResolver implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.TRACE, org.emftext.language.refactoring.roles.Role> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.refactoring_specification.TRACE container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<org.emftext.language.refactoring.roles.Role> result) {
		EObject parent = RefspecEObjectUtil.findRootContainer(container);
		if(!(parent instanceof RefactoringSpecification)){
			result.setErrorMessage("Not a valid Refactoring Specification");
			return;
		}
		RefactoringSpecification specification = (RefactoringSpecification) parent;
		RoleModel roleModel = specification.getUsedRoleModel();
		EList<Role> roles = roleModel.getRoles();
		for (Role role : roles) {
			if(role.getName().equals(identifier)){
				result.addMapping(identifier, role);
				return;
			}
		}
		result.setErrorMessage("Role '" + identifier + "' isn't declared in the specified RoleModel");
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.Role element, org.emftext.language.refactoring.refactoring_specification.TRACE container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
