/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.refactoring.rolemapping.postprocessing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.emftext.language.refactoring.rolemapping.AttributeMapping;
import org.emftext.language.refactoring.rolemapping.CollaborationMapping;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.RolemappingPackage;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.util.RolemappingEObjectUtil;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleAttribute;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleModifier;
import org.emftext.refactoring.util.RoleUtil;

/**
 * This postprocessor checks if all obligatory roles of a role model were mapped.
 * 
 * @author Jan Reimann
 *
 */
public class ConcreteMappingAnalyser extends AbstractPostProcessor {

	private static final String MAPPED_ROLE_MISSED 			= "The obligatory role '%1$s' has to be mapped.";
	private static final String MAPPED_COLLABORATION_MISSED	= "The collaboration '%1$s' has to be mapped.";
	private static final String MAPPED_ROLE_UNIQUE 			= "The role '%1$s' was mapped more than once.";
	private static final String MAPPED_COLLABORATION_UNIQUE	= "The collaboration '%1$s' was mapped more than once.";
	private static final String MAPPED_ATTRIBUTE_MISSED 	= "The non-optional attribute '%1$s' has to be mapped.";
	
	private List<Role> obligatoryRoles;
	private Set<Role> mappedRoles;
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.rolemapping.postprocessing.AbstractPostProcessor#analyse(org.emftext.language.refactoring.rolemapping.resource.rolemapping.mopp.RolemappingResource, org.emftext.language.refactoring.rolemapping.RoleMappingModel)
	 */
	@Override
	public void analyse(RolemappingResource resource, RoleMappingModel model) {
		Collection<RoleMapping> mappings = RolemappingEObjectUtil.getObjectsByType(model.eAllContents()
				, RolemappingPackage.eINSTANCE.getRoleMapping());
		for (RoleMapping mapping : mappings) {
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
				analyseObligatoryCollaborations(resource, concreteMapping);
			}
			if(!obligatoryRoles.isEmpty()){
				for (Role obligatoryRole : obligatoryRoles) {
					addProblem(resource
							, ERoleMappingModelProblemType.NOT_ALL_ROLES_MAPPED
							, String.format(MAPPED_ROLE_MISSED, obligatoryRole.getName())
							, mapping);
				}
			}
			analyseObligatoryAttributeMappings(resource, mapping);
		}
	}
	
	private void analyseObligatoryCollaborations(RolemappingResource resource, ConcreteMapping concreteMapping) {
		Role role = concreteMapping.getRole();
		List<Collaboration> collaborations = role.getOutgoing();
		List<Collaboration> collaborationsNotMapped = new ArrayList<Collaboration>(collaborations);
		List<CollaborationMapping> collaborationMappings = concreteMapping.getCollaborationMappings();
		for (CollaborationMapping collaborationMapping : collaborationMappings) {
			MultiplicityCollaboration mappedCollaboration = collaborationMapping.getCollaboration();
			if(collaborations.contains(mappedCollaboration)){
				if(!collaborationsNotMapped.remove(mappedCollaboration)){
					addProblem(resource
							, ERoleMappingModelProblemType.DUPLICATE_COLLABORATION_MAPPING
							, String.format(MAPPED_COLLABORATION_UNIQUE, mappedCollaboration.getTargetName())
							, concreteMapping);
				}
			}
		}
		RoleMapping roleMapping = (RoleMapping) concreteMapping.eContainer();
		List<Role> optionalRoles = RoleUtil.getAllOptionalRoles(roleMapping);
		List<Role> mappedOptionalRoles = new ArrayList<Role>();
		for (Role optionalRole : optionalRoles) {
			ConcreteMapping concreteMappingForRole = roleMapping.getConcreteMappingForRole(optionalRole);
			if(concreteMappingForRole != null){
				mappedOptionalRoles.add(concreteMappingForRole.getRole());
			}
		}
		for (Collaboration collaboration : collaborationsNotMapped) {
			if(collaboration instanceof MultiplicityCollaboration){
				Role targetRole = collaboration.getTarget();
				if(mappedOptionalRoles.contains(targetRole)){
					addProblem(resource
							, ERoleMappingModelProblemType.NOT_ALL_COLLABORATIONS_MAPPED
							, String.format(MAPPED_COLLABORATION_MISSED, ((MultiplicityCollaboration) collaboration).getTargetName())
							, concreteMapping);
				}
			}
		}
	}

	private void analyseObligatoryAttributeMappings(RolemappingResource resource, RoleMapping mapping){
		List<ConcreteMapping> concreteMappings = mapping.getRoleToMetaelement();
		for (ConcreteMapping concreteMapping : concreteMappings) {
			List<AttributeMapping> attributeMappings = concreteMapping.getAttributeMappings();
			List<RoleAttribute> mappedAttributes = new LinkedList<RoleAttribute>();
			if(attributeMappings != null){
				for (AttributeMapping attributeMapping : attributeMappings) {
					mappedAttributes.add(attributeMapping.getRoleAttribute());
				}
			}
			Role role = concreteMapping.getRole();
			List<RoleAttribute> attributes = role.getAttributes();
			for (RoleAttribute attribute : attributes) {
				if(!attribute.getModifier().contains(RoleModifier.OPTIONAL)){
					if(!mappedAttributes.contains(attribute)){
						addProblem(resource
								, ERoleMappingModelProblemType.NOT_ALL_ATTRIBUTES_MAPPED
								, String.format(MAPPED_ATTRIBUTE_MISSED, attribute.getName())
								, concreteMapping);
					}
				}
			}
		}
	}

	/**
	 * @param mapping
	 * @return
	 */
	private static List<Role> getObligatoryRoles(RoleMapping mapping) {
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

	public void terminate() {
		// do nothing
	}
}
