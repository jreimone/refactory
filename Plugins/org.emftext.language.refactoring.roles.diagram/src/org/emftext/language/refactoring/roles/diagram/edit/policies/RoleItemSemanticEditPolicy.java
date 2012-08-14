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
package org.emftext.language.refactoring.roles.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleAssociationCreateCommand;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleAssociationReorientCommand;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleCompositionCreateCommand;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleCompositionReorientCommand;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleImplicationCreateCommand;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleImplicationReorientCommand;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleProhibitionCreateCommand;
import org.emftext.language.refactoring.roles.diagram.edit.commands.RoleProhibitionReorientCommand;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAssociationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleAttributeEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleCompositionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleImplicationEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleProhibitionEditPart;
import org.emftext.language.refactoring.roles.diagram.edit.parts.RoleRoleAttributeCompartmentEditPart;
import org.emftext.language.refactoring.roles.diagram.part.RolesVisualIDRegistry;
import org.emftext.language.refactoring.roles.diagram.providers.RolesElementTypes;

/**
 * @generated
 */
public class RoleItemSemanticEditPolicy extends RolesBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RoleItemSemanticEditPolicy() {
		super(RolesElementTypes.Role_2001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (RolesVisualIDRegistry.getVisualID(incomingLink) == RoleImplicationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (RolesVisualIDRegistry.getVisualID(incomingLink) == RoleProhibitionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (RolesVisualIDRegistry.getVisualID(incomingLink) == RoleAssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (RolesVisualIDRegistry.getVisualID(incomingLink) == RoleCompositionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (RolesVisualIDRegistry.getVisualID(outgoingLink) == RoleImplicationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RolesVisualIDRegistry.getVisualID(outgoingLink) == RoleProhibitionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RolesVisualIDRegistry.getVisualID(outgoingLink) == RoleAssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RolesVisualIDRegistry.getVisualID(outgoingLink) == RoleCompositionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (RolesVisualIDRegistry.getVisualID(node)) {
			case RoleRoleAttributeCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (RolesVisualIDRegistry.getVisualID(cnode)) {
					case RoleAttributeEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command
				: super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (RolesElementTypes.RoleImplication_4001 == req.getElementType()) {
			return getGEFWrapper(new RoleImplicationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (RolesElementTypes.RoleProhibition_4002 == req.getElementType()) {
			return getGEFWrapper(new RoleProhibitionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (RolesElementTypes.RoleAssociation_4003 == req.getElementType()) {
			return getGEFWrapper(new RoleAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (RolesElementTypes.RoleComposition_4004 == req.getElementType()) {
			return getGEFWrapper(new RoleCompositionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (RolesElementTypes.RoleImplication_4001 == req.getElementType()) {
			return getGEFWrapper(new RoleImplicationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (RolesElementTypes.RoleProhibition_4002 == req.getElementType()) {
			return getGEFWrapper(new RoleProhibitionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (RolesElementTypes.RoleAssociation_4003 == req.getElementType()) {
			return getGEFWrapper(new RoleAssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (RolesElementTypes.RoleComposition_4004 == req.getElementType()) {
			return getGEFWrapper(new RoleCompositionCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case RoleImplicationEditPart.VISUAL_ID:
			return getGEFWrapper(new RoleImplicationReorientCommand(req));
		case RoleProhibitionEditPart.VISUAL_ID:
			return getGEFWrapper(new RoleProhibitionReorientCommand(req));
		case RoleAssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new RoleAssociationReorientCommand(req));
		case RoleCompositionEditPart.VISUAL_ID:
			return getGEFWrapper(new RoleCompositionReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
