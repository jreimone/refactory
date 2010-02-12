/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.emftext.language.refactoring.roles.Role;
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

	private static final String UNIQUE_ROLE_MODIFIER = "The modifier %1$s of Role %2$s mustn't be set repeatedly.";
	
	private Set<RoleModifier> uniqueModifier;
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.roles.resource.rolestext.options.AbstractPostProcessor#analyse(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource, org.emftext.language.refactoring.roles.RoleModel)
	 */
	@Override
	public void analyse(RolestextResource resource, RoleModel model) {
		Collection<Role> roles = RolestextEObjectUtil.getObjectsByType(model.eAllContents(), RolesPackage.eINSTANCE.getRole());
		for (Role role : roles) {
			uniqueModifier = new HashSet<RoleModifier>();
			List<RoleModifier> modifier = role.getModifier();
			for (RoleModifier roleModifier : modifier) {
				boolean unique = uniqueModifier.add(roleModifier);
				if(!unique){
					addProblem(resource
							, ERoleModelProblemType.ROLE_MODIFIER_ALREADY_SET
							, String.format(UNIQUE_ROLE_MODIFIER, modifier, role.getName())
							, role);
				}
			}
		}
	}

}
