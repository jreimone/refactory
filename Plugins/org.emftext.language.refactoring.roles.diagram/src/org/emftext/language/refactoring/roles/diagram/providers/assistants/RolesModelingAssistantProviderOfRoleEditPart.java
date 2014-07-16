package org.emftext.language.refactoring.roles.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleEditPart;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;
import org.emftext.language.refactoring.roles.diagram.providers.RolesModelingAssistantProvider;

/**
 * @generated
 */
public class RolesModelingAssistantProviderOfRoleEditPart extends
		RolesModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(RolesElementTypes.RoleAttribute_3001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((RoleEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(RoleEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(RolesElementTypes.RoleImplication_4001);
		types.add(RolesElementTypes.RoleProhibition_4002);
		types.add(RolesElementTypes.RoleAssociation_4003);
		types.add(RolesElementTypes.RoleComposition_4004);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((RoleEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			RoleEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof RoleEditPart) {
			types.add(RolesElementTypes.RoleImplication_4001);
		}
		if (targetEditPart instanceof RoleEditPart) {
			types.add(RolesElementTypes.RoleProhibition_4002);
		}
		if (targetEditPart instanceof RoleEditPart) {
			types.add(RolesElementTypes.RoleAssociation_4003);
		}
		if (targetEditPart instanceof RoleEditPart) {
			types.add(RolesElementTypes.RoleComposition_4004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((RoleEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(RoleEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == RolesElementTypes.RoleImplication_4001) {
			types.add(RolesElementTypes.Role_2001);
		} else if (relationshipType == RolesElementTypes.RoleProhibition_4002) {
			types.add(RolesElementTypes.Role_2001);
		} else if (relationshipType == RolesElementTypes.RoleAssociation_4003) {
			types.add(RolesElementTypes.Role_2001);
		} else if (relationshipType == RolesElementTypes.RoleComposition_4004) {
			types.add(RolesElementTypes.Role_2001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((RoleEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(RoleEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(RolesElementTypes.RoleImplication_4001);
		types.add(RolesElementTypes.RoleProhibition_4002);
		types.add(RolesElementTypes.RoleAssociation_4003);
		types.add(RolesElementTypes.RoleComposition_4004);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((RoleEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(RoleEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == RolesElementTypes.RoleImplication_4001) {
			types.add(RolesElementTypes.Role_2001);
		} else if (relationshipType == RolesElementTypes.RoleProhibition_4002) {
			types.add(RolesElementTypes.Role_2001);
		} else if (relationshipType == RolesElementTypes.RoleAssociation_4003) {
			types.add(RolesElementTypes.Role_2001);
		} else if (relationshipType == RolesElementTypes.RoleComposition_4004) {
			types.add(RolesElementTypes.Role_2001);
		}
		return types;
	}

}
