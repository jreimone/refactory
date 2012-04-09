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
package org.emftext.language.refactoring.roles.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
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
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Roles1Group_title);
		paletteContainer.setId("createRoles1Group"); //$NON-NLS-1$
		paletteContainer.add(createRole1CreationTool());
		paletteContainer.add(createRoleAttribute2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Collaborations" palette tool group
	 * @generated
	 */
	private PaletteContainer createCollaborations2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Collaborations2Group_title);
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
		NodeToolEntry entry = new NodeToolEntry(Messages.Role1CreationTool_title, Messages.Role1CreationTool_desc, Collections.singletonList(RolesElementTypes.Role_2001));
		entry.setId("createRole1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/role.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRoleAttribute2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.RoleAttribute2CreationTool_title, Messages.RoleAttribute2CreationTool_desc, Collections.singletonList(RolesElementTypes.RoleAttribute_3001));
		entry.setId("createRoleAttribute2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/roleattribute.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createImplication1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Implication1CreationTool_title, Messages.Implication1CreationTool_desc, Collections.singletonList(RolesElementTypes.RoleImplication_4001));
		entry.setId("createImplication1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/implication.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProhibition2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Prohibition2CreationTool_title, Messages.Prohibition2CreationTool_desc, Collections.singletonList(RolesElementTypes.RoleProhibition_4002));
		entry.setId("createProhibition2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/prohibition.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Association3CreationTool_title, Messages.Association3CreationTool_desc, Collections.singletonList(RolesElementTypes.RoleAssociation_4003));
		entry.setId("createAssociation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(RolesDiagramEditorPlugin.findImageDescriptor("/org.emftext.language.refactoring.roles.edit/icons/new/association.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComposition4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Composition4CreationTool_title, Messages.Composition4CreationTool_desc, Collections.singletonList(RolesElementTypes.RoleComposition_4004));
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
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
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
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
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
