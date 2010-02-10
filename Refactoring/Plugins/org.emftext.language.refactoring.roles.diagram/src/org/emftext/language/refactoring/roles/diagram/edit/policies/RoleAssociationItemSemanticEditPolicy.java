package org.emftext.language.refactoring.roles.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RoleAssociationItemSemanticEditPolicy extends
		RolesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RoleAssociationItemSemanticEditPolicy() {
		super(RolesElementTypes.RoleAssociation_4003);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
