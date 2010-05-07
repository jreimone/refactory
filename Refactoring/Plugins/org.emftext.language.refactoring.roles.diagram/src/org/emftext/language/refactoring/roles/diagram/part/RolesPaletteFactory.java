package org.emftext.language.refactoring.roles.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RolesPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createRoles1Group());
		paletteRoot.add(createCollaborations2Group());
	}

	/**
	 * Creates "Roles" palette tool group
	 * @generated
	 */
	private PaletteContainer createRoles1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Roles1Group_title);
		paletteContainer.setId("createRoles1Group"); //$NON-NLS-1$
		paletteContainer.add(createRole1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Collaborations" palette tool group
	 * @generated
	 */
	private PaletteContainer createCollaborations2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Collaborations2Group_title);
		paletteContainer.setId("createCollaborations2Group"); //$NON-NLS-1$
		paletteContainer.add(createImplication1CreationTool());
		paletteContainer.add(createProhibition2CreationTool());
		paletteContainer.add(createAssociation3CreationTool());
		paletteContainer.add(createComposition4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRole1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(RolesElementTypes.Role_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Role1CreationTool_title,
				Messages.Role1CreationTool_desc, types);
		entry.setId("createRole1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/role.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImplication1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(RolesElementTypes.RoleImplication_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Implication1CreationTool_title,
				Messages.Implication1CreationTool_desc, types);
		entry.setId("createImplication1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/implication.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProhibition2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(RolesElementTypes.RoleProhibition_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Prohibition2CreationTool_title,
				Messages.Prohibition2CreationTool_desc, types);
		entry.setId("createProhibition2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/prohibition.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(RolesElementTypes.RoleAssociation_4003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Association3CreationTool_title,
				Messages.Association3CreationTool_desc, types);
		entry.setId("createAssociation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/association.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComposition4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(RolesElementTypes.RoleComposition_4004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Composition4CreationTool_title,
				Messages.Composition4CreationTool_desc, types);
		entry.setId("createComposition4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/composition.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
