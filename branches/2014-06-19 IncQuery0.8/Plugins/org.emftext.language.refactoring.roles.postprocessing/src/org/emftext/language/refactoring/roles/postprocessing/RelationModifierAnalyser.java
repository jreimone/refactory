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
/**
 * 
 */
package org.emftext.language.refactoring.roles.postprocessing;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.CollaborationModifier;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource;
import org.emftext.language.refactoring.roles.resource.rolestext.util.RolestextEObjectUtil;

/**
 * Analyses the modifiers of relations and checks that every modifier occurs only once.
 * 
 * @author Jan Reimann
 *
 */
public class RelationModifierAnalyser extends AbstractPostProcessor {

	private static final String UNIQUE_RELATION_MODIFIER = "The modifier \"%1$s\" of %2$s between %3$s (source) and %4$s (target) mustn't be set repeatedly.";
	
	private Set<CollaborationModifier> uniqueModifier;
	
	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.roles.postprocessing.AbstractPostProcessor#analyse(org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextResource, org.emftext.language.refactoring.roles.RoleModel)
	 */
	@Override
	public void analyse(RolestextResource resource, RoleModel model) {
		Collection<Collaboration> collaborations = RolestextEObjectUtil.getObjectsByType(model.eAllContents(), RolesPackage.eINSTANCE.getCollaboration());
		for (Collaboration collaboration : collaborations) {
			uniqueModifier = new HashSet<CollaborationModifier>();
			List<CollaborationModifier> modifier = collaboration.getModifier();
			for (CollaborationModifier relationModifier : modifier) {
				boolean unique = uniqueModifier.add(relationModifier);
				if(!unique){
					addProblem(resource
							, ERoleModelProblemType.RELATION_MODIFIER_ALREADY_SET
							, String.format(UNIQUE_RELATION_MODIFIER, relationModifier.getName(), collaboration.eClass().getName(), collaboration.getSource().getName(), collaboration.getTarget().getName())
							, collaboration);
				}
			}
		}
	}

	public void terminate() {
		// do nothing
	}
}
