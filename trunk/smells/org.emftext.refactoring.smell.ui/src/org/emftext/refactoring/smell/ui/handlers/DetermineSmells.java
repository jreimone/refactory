package org.emftext.refactoring.smell.ui.handlers;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.emftext.refactoring.editorconnector.IEditorConnectorRegistry;
import org.emftext.refactoring.smell.registry.SmellChecker;

public class DetermineSmells extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Set<IFile> alreadyHandledFiles = new HashSet<IFile>();
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(activeEditor == null){
			return null;
		}
		IEditorConnector editorConnector = IEditorConnectorRegistry.INSTANCE.getEditorConnectorForEditorPart(activeEditor);
		if(editorConnector != null){
			IEditorInput editorInput = activeEditor.getEditorInput();
			if(editorInput instanceof IFileEditorInput){
				IFile openFile = ((IFileEditorInput) editorInput).getFile();
				if(alreadyHandledFiles.add(openFile)){
					SmellChecker.removeAllMarkers(openFile);
					SmellChecker.checkSmellsInFile(editorConnector, openFile);
				}
			}
		}
		
		return null;
	}

}
