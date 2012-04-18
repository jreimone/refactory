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

	@SuppressWarnings("unchecked")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if(selection instanceof ITextSelection){
			if(selection instanceof ITextSelection){
				IEditorPart editor = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getActiveEditor();
				if(isModelEditorInstance(editor)){
					ModelEditor modelEditor = (ModelEditor) editor;
					ModelResource resource = getResource(modelEditor);
					Model model = getModelFromSelection((ITextSelection) selection, resource);
					registerModel(model);
				}
			}
		}
		additionalExecution(event);
		return null;
	}
	
	protected abstract Model getModelFromSelection(ITextSelection selection, ModelResource resource);

	abstract protected boolean isModelEditorInstance(IEditorPart editor);
	
	abstract protected ModelResource getResource(ModelEditor editor);
	
	abstract protected void registerModel(Model model);
	
	/**
	 * Override this method for handlers needing more computation than only a text editor.
	 * @param event
	 */
	protected void additionalExecution(ExecutionEvent event){
		// default empty
	}
}
