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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends
		DiagramContextMenuProvider {

	/**
	 * @generated
	 */
	private IWorkbenchPart part;

	/**
	 * @generated
	 */
	private DeleteElementAction deleteAction;

	/**
	 * @generated
	 */
	public DiagramEditorContextMenuProvider(IWorkbenchPart part,
			EditPartViewer viewer) {
		super(part, viewer);
		this.part = part;
		deleteAction = new DeleteElementAction(part);
		deleteAction.init();
	}

	/**
	 * @generated
	 */
	public void dispose() {
		if (deleteAction != null) {
			deleteAction.dispose();
			deleteAction = null;
		}
		super.dispose();
	}

	/**
	 * @generated
	 */
	public void buildContextMenu(final IMenuManager menu) {
		getViewer().flush();
		try {
			TransactionUtil.getEditingDomain(
					(EObject) getViewer().getContents().getModel())
					.runExclusive(new Runnable() {

						public void run() {
							ContributionItemService
									.getInstance()
									.contributeToPopupMenu(
											DiagramEditorContextMenuProvider.this,
											part);
							menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
							menu.appendToGroup("editGroup", deleteAction);
						}
					});
		} catch (Exception e) {
			RolesDiagramEditorPlugin.getInstance().logError(
					"Error building context menu", e);
		}
	}
}
