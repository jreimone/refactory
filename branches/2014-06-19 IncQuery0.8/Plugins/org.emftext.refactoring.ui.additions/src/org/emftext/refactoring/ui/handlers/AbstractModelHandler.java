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
package org.emftext.refactoring.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class AbstractModelHandler <Model, ModelResource extends Resource, ModelEditor> extends AbstractHandler{

	private ModelEditor editor;
	
	@SuppressWarnings("unchecked")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if(selection instanceof ITextSelection){
			if(selection instanceof ITextSelection){
				IEditorPart editor = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getActiveEditor();
				if(isModelEditorInstance(editor)){
					ModelEditor modelEditor = (ModelEditor) editor;
					this.editor = modelEditor;
					ModelResource resource = getResource(modelEditor);
					Model model = getModelFromSelection((ITextSelection) selection, resource);
					executeWithModelInTextEditor(model);
				}
			}
		}
		additionalExecution(event);
		return null;
	}
	
	protected abstract Model getModelFromSelection(ITextSelection selection, ModelResource resource);

	abstract protected boolean isModelEditorInstance(IEditorPart editor);
	
	abstract protected ModelResource getResource(ModelEditor editor);
	
	abstract protected void executeWithModelInTextEditor(Model model);
	
	/**
	 * Override this method for handlers needing more computation than only a text editor.
	 * @param event
	 */
	protected void additionalExecution(ExecutionEvent event){
		// default empty
	}

	/**
	 * @return the editor
	 */
	public ModelEditor getEditor() {
		return editor;
	}
}
