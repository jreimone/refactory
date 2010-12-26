/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;

/**
 * Checks for every role that the target names of its outgoing relations are distinct.
 * This is needed to determine them for the RelationMapping in a role mapping model.
 * Besides that it will be checked if the target names are empty. This case isn't recommended
 * because of mapping reasons: in a role mapping model an outgoing relation without name can't be mapped adequately.
 * 
 * @author Jan Reimann
 *
 */
public class DistinctRelationNamesAnalyser extends AbstractPostProcessor {

	private static final String DUPLICATE_TARGET_NAME = "Duplicate target name '%1$s' of the outgoing relation of role '%2$s'";
	private static final String EMPTY_TARGET_NAME = "Target name of the outgoing relation of role '%1$s' shouldn't be empty to enable relation mapping in a role mapping";
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.roles.postprocessing.AbstractPostProcessor#analyse(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource, org.emftext.language.refactoring.roles.RoleModel)
	 */
	@Override
	public void analyse(RolestextResource resource, RoleModel model) {
		EcoreUtil.resolveAll(model);
		EList<Role> roles = model.getRoles();
		for (Role role : roles) {
			EList<Collaboration> collaborations = role.getOutgoing();
			Set<String> targetNames = new HashSet<String>();
			for (Collaboration relation : collaborations) {
				if(relation instanceof MultiplicityCollaboration){
					String targetName = ((MultiplicityCollaboration) relation).getTargetName();
					if(targetName == null || "".equals(targetName)){
						addProblem(resource
								, ERoleModelProblemType.EMPTY_OUTGOING_RELATION_TARGET_NAME
								, String.format(EMPTY_TARGET_NAME, role.getName())
								, relation);
					} else if(!targetNames.add(targetName)){
						addProblem(resource
								, ERoleModelProblemType.DUPLICATE_OUTGOING_RELATION_TARGET_NAMES
								, String.format(DUPLICATE_TARGET_NAME, targetName, role.getName())
								, relation);
					}
				}
			}
		}
	}

	public void terminate() {
		// do nothing
	}
}
