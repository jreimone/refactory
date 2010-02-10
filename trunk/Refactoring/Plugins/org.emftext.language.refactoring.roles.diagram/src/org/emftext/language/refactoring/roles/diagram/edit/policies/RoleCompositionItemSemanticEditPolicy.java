package org.emftext.language.refactoring.roles.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RoleCompositionItemSemanticEditPolicy extends
		RolesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RoleCompositionItemSemanticEditPolicy() {
		super(RolesElementTypes.RoleComposition_4004);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
