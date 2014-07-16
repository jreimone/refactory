package org.emftext.language.refactoring.roles.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;
import org.emftext.language.refactoring.roles.diagram.providers.RolesModelingAssistantProvider;

/**
 * @generated
 */
public class RolesModelingAssistantProviderOfRoleModelEditPart extends
		RolesModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(RolesElementTypes.Role_2001);
		return types;
	}

}
