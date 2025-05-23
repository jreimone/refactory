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
package org.emftext.language.refactoring.roles.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry;

/**
 * @generated
 */
public class RolesEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (RolesVisualIDRegistry.getVisualID(view)) {

			case RoleModelEditPart.VISUAL_ID:
				return new RoleModelEditPart(view);

			case RoleEditPart.VISUAL_ID:
				return new RoleEditPart(view);

			case RoleNameEditPart.VISUAL_ID:
				return new RoleNameEditPart(view);

			case RoleAttributeEditPart.VISUAL_ID:
				return new RoleAttributeEditPart(view);

			case RoleAttributeNameEditPart.VISUAL_ID:
				return new RoleAttributeNameEditPart(view);

			case RoleRoleAttributeCompartmentEditPart.VISUAL_ID:
				return new RoleRoleAttributeCompartmentEditPart(view);

			case RoleImplicationEditPart.VISUAL_ID:
				return new RoleImplicationEditPart(view);

			case RoleProhibitionEditPart.VISUAL_ID:
				return new RoleProhibitionEditPart(view);

			case RoleAssociationEditPart.VISUAL_ID:
				return new RoleAssociationEditPart(view);

			case RoleAssociationSourceNameEditPart.VISUAL_ID:
				return new RoleAssociationSourceNameEditPart(view);

			case RoleAssociationTargetNameEditPart.VISUAL_ID:
				return new RoleAssociationTargetNameEditPart(view);

			case RoleCompositionEditPart.VISUAL_ID:
				return new RoleCompositionEditPart(view);

			case RoleCompositionSourceNameEditPart.VISUAL_ID:
				return new RoleCompositionSourceNameEditPart(view);

			case RoleCompositionTargetNameEditPart.VISUAL_ID:
				return new RoleCompositionTargetNameEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}
}
