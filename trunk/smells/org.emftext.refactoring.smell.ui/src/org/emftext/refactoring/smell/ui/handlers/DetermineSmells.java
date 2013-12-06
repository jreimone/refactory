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
import org.emftext.refactoring.smell.registry.SmellChecker;

public class DetermineSmells extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Set<IFile> alreadyHandledFiles = new HashSet<IFile>();
		//		try {
		// open files
		//			IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		//			for (IEditorReference editorReference : editorReferences) {
		if(activeEditor == null){
			return null;
		}
		IEditorInput editorInput = activeEditor.getEditorInput();
		if(editorInput instanceof IFileEditorInput){
			IFile openFile = ((IFileEditorInput) editorInput).getFile();
			if(alreadyHandledFiles.add(openFile)){
				SmellChecker.removeAllMarkers(openFile);
				SmellChecker.checkSmellsInFile(openFile, activeEditor);
				//					openFile.touch(new NullProgressMonitor());
			}
		}
		//			}
		// marked files
		//			IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot().findMarkers(IQualitySmellMarker.ID, true, IResource.DEPTH_INFINITE);
		//			for (IMarker marker : markers) {
		//				IFile file = (IFile) marker.getResource();
		//				if(alreadyHandledFiles.add(file)){
		//					SmellChecker.removeAllMarkers(file);
		////					file.touch(new NullProgressMonitor());
		//				}
		//			}
		//		} catch (CoreException e) {
		//			e.printStackTrace();
		//		}
		return null;
	}

}
