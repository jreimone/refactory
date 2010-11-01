package org.emftext.language.ecore.resource.text.quickfixes;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreQuickFix;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.interpreter.IRefactorer;
import org.emftext.refactoring.ui.RefactoringAction;

public class ExtractSuperClassQuickFix extends TextEcoreQuickFix {

	private static final String REFACTOR_EXTRACT_SUPER_CLASS = "Refactor: Extract SuperClass from common attributes";
	
	//// from here all is the same 
	
	private IRefactorer refactorer;
	private RoleMapping mapping;
	
	public ExtractSuperClassQuickFix(RoleMapping mapping, List<EObject> attributesToPullUp, IRefactorer refactorer, String iconKey) {
		super(REFACTOR_EXTRACT_SUPER_CLASS, iconKey, attributesToPullUp);
		this.refactorer = refactorer;
		this.mapping = mapping;
	}

	@Override
	public void applyChanges() {
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IEditorConnector connector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
		if(connector != null){
			RefactoringAction action = new RefactoringAction(mapping, refactorer, connector);
			action.run();
		}
	}

}
