package org.emftext.refactoring.smell.smell_model.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.refactoring.roles.resource.rolestext.mopp.RolestextQuickFix;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.ui.RefactoringAction;

public class RefactoringQuickfix extends RolestextQuickFix {

	 private IRefactorer refactorer;
	
	 public RefactoringQuickfix(EObject objectToBeRefactored, IRefactorer refactorer, String iconKey){
         super("Refactor: " + refactorer.getRoleMapping().getName(), iconKey,  objectToBeRefactored);
         this.refactorer = refactorer;
         this.refactorer.setInput(Collections.singletonList(objectToBeRefactored));
 }

	@Override
	public void applyChanges() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
        IEditorConnector connector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
        RefactoringAction action = new RefactoringAction(refactorer, connector);
//        for (IMarker marker : ModelSmellModelImpl.getMain().getMarkerRefactoring().keySet()){
//        	if(ModelSmellModelImpl.getMain().getMarkerRefactoring().get(marker).equals(this)){
//        		try {
//        			ModelSmellModelImpl.getMain().getMarkerRefactoring().remove(marker);
//					marker.delete();
//				} catch (CoreException e) {
//					e.printStackTrace();
//				}
//        	}
//        }
        action.run();
	}

}
