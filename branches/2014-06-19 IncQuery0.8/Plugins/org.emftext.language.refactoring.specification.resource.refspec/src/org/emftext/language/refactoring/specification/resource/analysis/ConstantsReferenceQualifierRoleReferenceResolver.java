/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.refactoring_specification.Constants;
import org.emftext.language.refactoring.refactoring_specification.ConstantsReference;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult;
import org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver;
import org.emftext.refactoring.util.RoleUtil;

public class ConstantsReferenceQualifierRoleReferenceResolver implements IRefspecReferenceResolver<ConstantsReference, Role> {
	
	public void resolve(String identifier, ConstantsReference contanstReference, EReference reference, int position, boolean resolveFuzzy, final IRefspecReferenceResolveResult<Role> result) {
		EObject parent = EcoreUtil.getRootContainer(contanstReference, true);
		if(!(parent instanceof RefactoringSpecification)){
			result.setErrorMessage("Not a valid Refactoring Specification");
			return;
		}
		RefactoringSpecification specification = (RefactoringSpecification) parent;
		RoleModel roleModel = specification.getUsedRoleModel();
		Constants constant = contanstReference.getReferencedConstant();
		switch (constant) {
		case INPUT:
			List<Role> inputRoles = RoleUtil.getAllInputRoles(roleModel);
			if(resolveFuzzy){
				for (Role role : inputRoles) {
					result.addMapping(role.getName(), role);
				}
				return;
			} else {
				for (Role role : inputRoles) {
					if(role.getName().equals(identifier)){
						result.addMapping(identifier, role);
						return;
					}
				}
			}
			result.setErrorMessage("Role '" + identifier + "' isn't declared in the specified RoleModel");
			break;

		default:
			break;
		}
	}
	
	public String deResolve(Role role, ConstantsReference container, EReference reference) {
		return role.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
