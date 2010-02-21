/**
 * 
 */
package org.emftext.language.refactoring.specification.resource.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.refactoring_specification.ASSIGN;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.refactoring_specification.Variable;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.specification.resource.util.RefspecEObjectUtil;


/**
 * An abstract reference resolver because ASSIGNSourceAttributeResolver and ASSIGNTargetAttributeResolver need the same code.
 * 
 * @author Jan Reimann
 *
 */
public abstract class AbstractRoleAttributeResolver implements org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolver<org.emftext.language.refactoring.refactoring_specification.ASSIGN, org.emftext.language.refactoring.roles.RoleAttribute>  {

	public AbstractRoleAttributeResolver() {
		super();
	}

	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.refactoring_specification.ASSIGN container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.specification.resource.IRefspecReferenceResolveResult<org.emftext.language.refactoring.roles.RoleAttribute> result) {
		String[] roleAttrib = identifier.split("\\.");
		if(roleAttrib[0] == null){
			result.setErrorMessage("A role must be specified before the '.'");
		}
		if(roleAttrib[1] == null){
			result.setErrorMessage("An attribute must be specified with '.' notation after the role");
		}
		String roleString = roleAttrib[0];
		String attributeString = roleAttrib[1];
		EObject parent = RefspecEObjectUtil.findRootContainer(container);
		if(!(parent instanceof RefactoringSpecification)){
			result.setErrorMessage("This is not a valid Refactoring Specification");
		}
		RefactoringSpecification refSpec = (RefactoringSpecification) parent;
		EList<Variable> variables = refSpec.getDeclaredVariables();
		Variable var = null;
		for (Variable variable : variables) {
			if(variable.getName().equals(roleString)){
				var = variable;
			}
		}
		Role matchedRole = null;
		if(var == null){
			RoleModel roleModel = refSpec.getUsedRoleModel();
			EList<Role> roles = roleModel.getRoles();
			for (Role role : roles) {
				if(role.getName().equals(roleString)){
					matchedRole = role;
					break;
				}
			}
		} else {
			matchedRole = var.getCreateCommand().getSourceRoleReference().getRole();
		}
		if(matchedRole == null){
			result.setErrorMessage("The name '" + roleString + "' doesn't match a role in the given RoleModel");
			return;
		}
		EList<RoleAttribute> attributes = matchedRole.getAttributes();
		for (RoleAttribute attribute : attributes) {
			if(attribute.getName().equals(attributeString)){
				result.addMapping(identifier, attribute);
				return;
			}
		}
		result.setErrorMessage("Role '" + roleString + "' has no attribute with name '" + attributeString +"'");
	}

	public java.lang.String deResolve(org.emftext.language.refactoring.roles.RoleAttribute element, org.emftext.language.refactoring.refactoring_specification.ASSIGN container, org.eclipse.emf.ecore.EReference reference) {
		return element.getAttributeRole().getName() + "." + element.getName();
	}

	/**
	 * The implementors must return whether source attribute or target attribute of the ASSIGN container.
	 * @param container
	 * @return
	 */
	protected abstract RoleAttribute getSpecificRole(ASSIGN container);
}