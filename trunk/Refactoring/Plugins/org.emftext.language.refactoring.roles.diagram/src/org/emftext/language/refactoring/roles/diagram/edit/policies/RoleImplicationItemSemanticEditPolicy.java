package org.emftext.language.refactoring.roles.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RoleImplicationItemSemanticEditPolicy extends
		RolesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RoleImplicationItemSemanticEditPolicy() {
		super(RolesElementTypes.RoleImplication_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
