package org.emftext.language.refactoring.rolemapping.postprocessing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.Mapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.util.RolemappingEObjectUtil;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;

public class ConcreteMappingAnayser extends AbstractPostProcessor {

	private static final String MAPPED_ROLE_MISSED = "The obligatory role '%1$s' wasn't mapped. It will be asked for at runtime.";
	private static final String MAPPED_ROLE_UNIQUE = "The role '%1$s' was mapped more than once.";
	
	private List<Role> obligatoryRoles;
	private Set<Role> mappedRoles;
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.rolemapping.postprocessing.AbstractPostProcessor#analyse(org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource, org.emftext.language.refactoring.rolemapping.RoleMappingModel)
	 */
	@Override
	public void analyse(RolemappingResource resource, RoleMappingModel model) {
		Collection<Mapping> mappings = RolemappingEObjectUtil.getObjectsByType(model.eAllContents()
				, RolemappingPackage.eINSTANCE.getMapping());
		for (Mapping mapping : mappings) {
			obligatoryRoles = getObligatoryRoles(mapping);
			mappedRoles = new HashSet<Role>();
			EList<ConcreteMapping> concreteMappings = mapping.getRoleToMetaelement();
			for (ConcreteMapping concreteMapping : concreteMappings) {
				Role mappedRole = concreteMapping.getRole();
				if(obligatoryRoles.contains(mappedRole)){
					obligatoryRoles.remove(mappedRole);
				}
				if(!mappedRoles.add(mappedRole)){
					addProblem(resource
							, ERoleMappingModelProblemType.DUPLICATE_ROLE_MAPPING
							, String.format(MAPPED_ROLE_UNIQUE, mappedRole.getName())
							, concreteMapping);
				}
			}
			if(!obligatoryRoles.isEmpty()){
				for (Role obligatoryRole : obligatoryRoles) {
					addProblem(resource
							, ERoleMappingModelProblemType.NOT_ALL_ROLES_MAPPED
							, String.format(MAPPED_ROLE_MISSED, obligatoryRole.getName())
							, mapping);
				}
			}
		}
	}

	/**
	 * @param mapping
	 * @return
	 */
	private static List<Role> getObligatoryRoles(Mapping mapping) {
		RoleModel roleModel = mapping.getMappedRoleModel();
		EList<Role> roles = roleModel.getRoles();
		List<Role> nonOptionalRoles = new ArrayList<Role>();
		for (Role role : roles) {
			if(!role.getModifier().contains(RoleModifier.OPTIONAL)){
				nonOptionalRoles.add(role);
			}
		}
		return nonOptionalRoles;
	}

}
