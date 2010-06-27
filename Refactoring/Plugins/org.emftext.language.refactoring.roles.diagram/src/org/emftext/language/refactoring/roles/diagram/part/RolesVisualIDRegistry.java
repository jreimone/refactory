package org.emftext.language.refactoring.roles.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RolesPackage;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationSourceNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationTargetNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionSourceNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionTargetNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleImplicationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleModelEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleProhibitionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleRoleAttributeCompartmentEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class RolesVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.emftext.language.refactoring.roles.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (RoleModelEditPart.MODEL_ID.equals(view.getType())) {
				return RoleModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				RolesDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (RolesPackage.eINSTANCE.getRoleModel().isSuperTypeOf(domainElement.eClass()) && isDiagram((RoleModel) domainElement)) {
			return RoleModelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry.getModelID(containerView);
		if (!RoleModelEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (RoleModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RoleModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
			case RoleModelEditPart.VISUAL_ID:
				if (RolesPackage.eINSTANCE.getRole().isSuperTypeOf(domainElement.eClass())) {
					return RoleEditPart.VISUAL_ID;
				}
				break;
			case RoleRoleAttributeCompartmentEditPart.VISUAL_ID:
				if (RolesPackage.eINSTANCE.getRoleAttribute().isSuperTypeOf(domainElement.eClass())) {
					return RoleAttributeEditPart.VISUAL_ID;
				}
				break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry.getModelID(containerView);
		if (!RoleModelEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (RoleModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RoleModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
			case RoleModelEditPart.VISUAL_ID:
				if (RoleEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case RoleEditPart.VISUAL_ID:
				if (RoleNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				if (RoleRoleAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case RoleAttributeEditPart.VISUAL_ID:
				if (RoleAttributeNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case RoleRoleAttributeCompartmentEditPart.VISUAL_ID:
				if (RoleAttributeEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case RoleAssociationEditPart.VISUAL_ID:
				if (RoleAssociationSourceNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				if (RoleAssociationTargetNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case RoleCompositionEditPart.VISUAL_ID:
				if (RoleCompositionSourceNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				if (RoleCompositionTargetNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (RolesPackage.eINSTANCE.getRoleImplication().isSuperTypeOf(domainElement.eClass())) {
			return RoleImplicationEditPart.VISUAL_ID;
		}
		if (RolesPackage.eINSTANCE.getRoleProhibition().isSuperTypeOf(domainElement.eClass())) {
			return RoleProhibitionEditPart.VISUAL_ID;
		}
		if (RolesPackage.eINSTANCE.getRoleAssociation().isSuperTypeOf(domainElement.eClass())) {
			return RoleAssociationEditPart.VISUAL_ID;
		}
		if (RolesPackage.eINSTANCE.getRoleComposition().isSuperTypeOf(domainElement.eClass())) {
			return RoleCompositionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(RoleModel element) {
		return true;
	}

}
