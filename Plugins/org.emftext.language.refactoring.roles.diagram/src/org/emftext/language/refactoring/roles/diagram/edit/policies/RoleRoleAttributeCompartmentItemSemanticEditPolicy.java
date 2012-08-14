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
package org.emftext.language.refactoring.roles.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleAttributeCreateCommand;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RoleRoleAttributeCompartmentItemSemanticEditPolicy extends
		RolesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RoleRoleAttributeCompartmentItemSemanticEditPolicy() {
		super(RolesElementTypes.Role_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (RolesElementTypes.RoleAttribute_3001 == req.getElementType()) {
			return getGEFWrapper(new RoleAttributeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
