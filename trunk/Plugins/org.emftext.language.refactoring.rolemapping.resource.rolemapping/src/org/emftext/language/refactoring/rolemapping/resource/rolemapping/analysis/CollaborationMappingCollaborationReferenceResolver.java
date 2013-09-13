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
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.refactoring.rolemapping.resource.rolemapping.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.ConcreteMapping;
import org.emftext.language.refactoring.roles.Collaboration;
import org.emftext.language.refactoring.roles.MultiplicityCollaboration;
import org.emftext.language.refactoring.roles.Role;

public class CollaborationMappingCollaborationReferenceResolver implements org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolver<org.emftext.language.refactoring.rolemapping.CollaborationMapping, org.emftext.language.refactoring.roles.MultiplicityCollaboration> {
	
	public void resolve(java.lang.String identifier, org.emftext.language.refactoring.rolemapping.CollaborationMapping container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingReferenceResolveResult<org.emftext.language.refactoring.roles.MultiplicityCollaboration> result) {
		EObject parent = container.eContainer();
		if (!(parent instanceof ConcreteMapping)) {
			result.setErrorMessage("Invalid RoleMapping Model");
			return;
		}
		ConcreteMapping concreteMapping = (ConcreteMapping) parent;
		String targetName = identifier;
		if (targetName == null) {
			targetName = "";
		}
		targetName = targetName.trim();
		Role mappedRole = concreteMapping.getRole();
		EList<Collaboration> outgoingRelations = mappedRole.getOutgoing();
		for (Collaboration collaboration : outgoingRelations) {
			if (collaboration instanceof MultiplicityCollaboration) {
				String relationTargetName = ((MultiplicityCollaboration) collaboration).getTargetName();
				if (relationTargetName == null) {
					relationTargetName = "";
				}
				relationTargetName = relationTargetName.trim();
				if (targetName.equals(relationTargetName) || resolveFuzzy) {
					result.addMapping(relationTargetName, (MultiplicityCollaboration) collaboration);
					if (!resolveFuzzy) {
						return;
					}
				}
			}
		}
		if(!resolveFuzzy){
			result.setErrorMessage("Role '" + mappedRole.getName() + "' has no outgoing relation with target name '" + targetName + "'");
		}
	}
	
	public java.lang.String deResolve(org.emftext.language.refactoring.roles.MultiplicityCollaboration element, org.emftext.language.refactoring.rolemapping.CollaborationMapping container, org.eclipse.emf.ecore.EReference reference) {
		return element.getTargetName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
