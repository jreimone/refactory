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
package org.eclipse.gmf.refactoring.editorconnector;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.emftext.refactoring.editorconnector.IEditorConnector;

public class GMFEditorConnector implements IEditorConnector {

	private TransactionalEditingDomain diagramTransactionalEditingDomain;

	public GMFEditorConnector() {
		// 
	}

	public boolean canHandle(IEditorPart editor) {
		try {
			ISelection selection = editor.getEditorSite().getSelectionProvider().getSelection();
			if(selection instanceof StructuredSelection){
				Object first = ((StructuredSelection) selection).getFirstElement();
				if(first != null && first instanceof EditPart){
					EditPartViewer viewer = ((EditPart) first).getViewer();
					if(viewer instanceof IDiagramGraphicalViewer){
						diagramTransactionalEditingDomain = ((IGraphicalEditPart) first).getEditingDomain();
						return true;
					}
				}
			}
		} catch (Exception e) {
			// not an GMF editor
		}
		return false;
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return diagramTransactionalEditingDomain;
	}


	public List<EObject> handleSelection(ISelection selection) {
		StructuredSelection structuredSelection = (StructuredSelection) selection;
		List<EObject> selectedElements = new LinkedList<EObject>();
		@SuppressWarnings("unchecked")
		List<EditPart> editParts = (List<EditPart>) structuredSelection.toList();
		for (EditPart editPart : editParts) {
			Object model = editPart.getModel();
			if(model instanceof View){
				selectedElements.add(((View) model).getElement());
			}
		}
		return selectedElements;
	}

	public void selectEObjects(List<EObject> objectsToSelect) {
		// TODO implement selection of graphical refactored elements
	}

}
