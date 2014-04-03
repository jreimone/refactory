package org.modelrefactoring.editorconnector.jdt;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.refactoring.editorconnector.IEditorConnector;

@SuppressWarnings("restriction")
public class JDTEditorConnectorAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if(adapterType.equals(IEditorConnector.class) && adaptableObject instanceof CompilationUnitEditor){
			CompilationUnitEditor jdtEditor = (CompilationUnitEditor) adaptableObject;
			ITextEditor textEditor = (ITextEditor) jdtEditor.getAdapter(ITextEditor.class);
			IEditorInput editorInput = textEditor.getEditorInput();
			if(editorInput instanceof IFileEditorInput){
				IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;
				IFile file = fileEditorInput.getFile();
				return new JDTEditorConnector(textEditor, file);
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IEditorConnector.class };
	}

}
