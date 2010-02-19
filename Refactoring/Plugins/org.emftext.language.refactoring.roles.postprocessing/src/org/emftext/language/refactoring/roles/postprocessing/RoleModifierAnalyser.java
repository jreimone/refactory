/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.roles.NamedElement;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;
import org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextEObjectUtil;

/**
 * Analyses the set modifiers of the roles and checks that every modifier occurs only once.
 * 
 * @author Jan Reimann
 *
 */
public class RoleModifierAnalyser extends AbstractPostProcessor {

	private static final String UNIQUE_ROLE_MODIFIER = "The modifier \"%1$s\" of %2$s %3$s mustn't be set repeatedly.";
	private static final String NO_INPUT_ROLE = "The Role Model contains no roles specified for input";
	
	private boolean inputRoleSet;
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.roles.resource.rolestext.options.AbstractPostProcessor#analyse(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource, org.emftext.language.refactoring.roles.RoleModel)
	 */
	@Override
	public void analyse(RolestextResource resource, RoleModel model) {
		Collection<Role> roles = RolestextEObjectUtil.getObjectsByType(model.eAllContents(), RolesPackage.eINSTANCE.getRole());
		inputRoleSet = false;
		for (Role role : roles) {
			List<RoleModifier> modifier = role.getModifier();
			analyseModifier(resource, role, modifier);
			EList<RoleAttribute> attributes = role.getAttributes();
			for (RoleAttribute roleAttribute : attributes) {
				EList<RoleModifier> attModifier = roleAttribute.getModifier();
				analyseModifier(resource, roleAttribute, attModifier);
			}
		}
		if(!inputRoleSet){
			addProblem(resource
					, ERoleModelProblemType.INPUT_ROLE_NOT_SET
					, NO_INPUT_ROLE
					, model);
		}
	}

	/**
	 * @param resource
	 * @param nameable
	 * @param modifier
	 */
	private void analyseModifier(RolestextResource resource, NamedElement nameable, List<RoleModifier> modifier) {
		Set<RoleModifier> uniqueModifier = new HashSet<RoleModifier>();
		for (RoleModifier roleModifier : modifier) {
			if(roleModifier.equals(RoleModifier.INPUT)){
				inputRoleSet = true;
			}
			boolean unique = uniqueModifier.add(roleModifier);
			if(!unique){
				addProblem(resource
						, ERoleModelProblemType.ROLE_MODIFIER_ALREADY_SET
						, String.format(UNIQUE_ROLE_MODIFIER, roleModifier.getName(), nameable.eClass().getName(), nameable.getName())
						, nameable);
			}
		}
	}

}
