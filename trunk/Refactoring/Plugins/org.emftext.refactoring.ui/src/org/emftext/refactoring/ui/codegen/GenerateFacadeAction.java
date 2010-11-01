package org.emftext.refactoring.ui.codegen;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GenerateFacadeAction implements IObjectActionDelegate {

	private ISelection selection;

	public void run(IAction action) {
		if(selection instanceof IStructuredSelection){
			for (Object selectedElement : ((IStructuredSelection) selection).toArray()) {
				if(selectedElement instanceof IFolder){
					// determine if rolemapping files are contained in the folder and then start generation
				}
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

}
