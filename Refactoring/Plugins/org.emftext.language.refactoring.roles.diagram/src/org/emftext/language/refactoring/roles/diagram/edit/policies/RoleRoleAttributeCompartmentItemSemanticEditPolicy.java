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
