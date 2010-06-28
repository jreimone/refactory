package org.emftext.language.refactoring.roles.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.emftext.language.refactoring.roles.RoleImplication;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.RoleProhibition;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationSourceNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionSourceNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleImplicationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleModelEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleNameEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleProhibitionEditPart;
import org.emftext.language.refactoring.roles.diagram.part.RolesDiagramEditorPlugin;
import org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;
import org.emftext.language.refactoring.roles.diagram.providers.RolesParserProvider;

/**
 * @generated
 */
public class RolesNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		RolesDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		RolesDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof RolesNavigatorItem
				&& !isOwnView(((RolesNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof RolesNavigatorGroup) {
			RolesNavigatorGroup group = (RolesNavigatorGroup) element;
			return RolesDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof RolesNavigatorItem) {
			RolesNavigatorItem navigatorItem = (RolesNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleImplicationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/roles?RoleImplication", RolesElementTypes.RoleImplication_4001); //$NON-NLS-1$
		case RoleProhibitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/roles?RoleProhibition", RolesElementTypes.RoleProhibition_4002); //$NON-NLS-1$
		case RoleEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://www.emftext.org/language/roles?Role", RolesElementTypes.Role_2001); //$NON-NLS-1$
		case RoleAttributeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://www.emftext.org/language/roles?RoleAttribute", RolesElementTypes.RoleAttribute_3001); //$NON-NLS-1$
		case RoleModelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://www.emftext.org/language/roles?RoleModel", RolesElementTypes.RoleModel_1000); //$NON-NLS-1$
		case RoleCompositionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/roles?RoleComposition", RolesElementTypes.RoleComposition_4004); //$NON-NLS-1$
		case RoleAssociationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://www.emftext.org/language/roles?RoleAssociation", RolesElementTypes.RoleAssociation_4003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = RolesDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& RolesElementTypes.isKnownElementType(elementType)) {
			image = RolesElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof RolesNavigatorGroup) {
			RolesNavigatorGroup group = (RolesNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof RolesNavigatorItem) {
			RolesNavigatorItem navigatorItem = (RolesNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (RolesVisualIDRegistry.getVisualID(view)) {
		case RoleImplicationEditPart.VISUAL_ID:
			return getRoleImplication_4001Text(view);
		case RoleProhibitionEditPart.VISUAL_ID:
			return getRoleProhibition_4002Text(view);
		case RoleEditPart.VISUAL_ID:
			return getRole_2001Text(view);
		case RoleAttributeEditPart.VISUAL_ID:
			return getRoleAttribute_3001Text(view);
		case RoleModelEditPart.VISUAL_ID:
			return getRoleModel_1000Text(view);
		case RoleCompositionEditPart.VISUAL_ID:
			return getRoleComposition_4004Text(view);
		case RoleAssociationEditPart.VISUAL_ID:
			return getRoleAssociation_4003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getRoleModel_1000Text(View view) {
		RoleModel domainModelElement = (RoleModel) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			RolesDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRole_2001Text(View view) {
		IParser parser = RolesParserProvider.getParser(
				RolesElementTypes.Role_2001,
				view.getElement() != null ? view.getElement() : view,
				RolesVisualIDRegistry.getType(RoleNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RolesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRoleAttribute_3001Text(View view) {
		IParser parser = RolesParserProvider.getParser(
				RolesElementTypes.RoleAttribute_3001,
				view.getElement() != null ? view.getElement() : view,
				RolesVisualIDRegistry
						.getType(RoleAttributeNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RolesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRoleImplication_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRoleProhibition_4002Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getRoleAssociation_4003Text(View view) {
		IParser parser = RolesParserProvider.getParser(
				RolesElementTypes.RoleAssociation_4003,
				view.getElement() != null ? view.getElement() : view,
				RolesVisualIDRegistry
						.getType(RoleAssociationSourceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RolesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRoleComposition_4004Text(View view) {
		IParser parser = RolesParserProvider.getParser(
				RolesElementTypes.RoleComposition_4004,
				view.getElement() != null ? view.getElement() : view,
				RolesVisualIDRegistry
						.getType(RoleCompositionSourceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			RolesDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return RoleModelEditPart.MODEL_ID.equals(RolesVisualIDRegistry
				.getModelID(view));
	}

}
