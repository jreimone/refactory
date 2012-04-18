package org.emftext.refactoring.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextTextResource;
import org.emftext.language.refactoring.roles.resource.rolestext.ui.RolestextEditor;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;
import org.emftext.refactoring.registry.rolemodel.exceptions.RoleModelAlreadyRegisteredException;

public class RegisterRoleModelHandler extends AbstractModelHandler <RoleModel, IRolestextTextResource, RolestextEditor>  {

	@Override
	protected boolean isModelEditorInstance(IEditorPart editor) {
		return editor instanceof RolestextEditor;
	}

	@Override
	protected IRolestextTextResource getResource(RolestextEditor editor) {
		return editor.getResource();
	}

	@Override
	protected void registerModel(RoleModel model) {
		try {
			IRoleModelRegistry.INSTANCE.registerRoleModel(model);
		} catch (RoleModelAlreadyRegisteredException e) {
			// do nothing
		}
	}

	@Override
	protected void additionalExecution(ExecutionEvent event) {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if(selection instanceof IStructuredSelection){
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object firstElement = structuredSelection.getFirstElement();
			if(firstElement instanceof EditPart){
				Object model = ((EditPart) firstElement).getModel();
				if(model instanceof View){
					EObject element = ((View) model).getElement();
					EObject container = EcoreUtil.getRootContainer(element, true);
					if(container instanceof RoleModel){
						try {
							IRoleModelRegistry.INSTANCE.registerRoleModel((RoleModel) container);
						} catch (RoleModelAlreadyRegisteredException e) {
							// do nothing
						}
					}
				}
			}
		}
	}

	@Override
	protected RoleModel getModelFromSelection(ITextSelection selection, IRolestextTextResource resource) {
		return (RoleModel) resource.getContents().get(0);
	}
}
