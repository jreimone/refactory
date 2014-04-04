package org.modelrefactoring.editorconnector.jdt;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.resource.java.IJavaTextResource;
import org.emftext.refactoring.editorconnector.IEditorConnector;

@SuppressWarnings("restriction")
public class JDTEditorConnectorAdapterFactory implements IAdapterFactory {

	private static final Map<IFile, JDTEditorConnector> fileEditorConnectorMap = new HashMap<IFile, JDTEditorConnector>();
	
	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if(adapterType.equals(IEditorConnector.class) && adaptableObject instanceof CompilationUnitEditor){
			CompilationUnitEditor jdtEditor = (CompilationUnitEditor) adaptableObject;
			ITextEditor textEditor = (ITextEditor) jdtEditor.getAdapter(ITextEditor.class);
			IEditorInput editorInput = textEditor.getEditorInput();
			if(editorInput instanceof IFileEditorInput){
				IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;
				IFile file = fileEditorInput.getFile();
				JDTEditorConnector editorConnector = fileEditorConnectorMap.get(file);
				if(editorConnector == null){
					URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
					ResourceSet rs = new ResourceSetImpl();
					IJavaTextResource resource = (IJavaTextResource) rs.getResource(uri, true);
					editorConnector = new JDTEditorConnector(textEditor, resource);
					fileEditorConnectorMap.put(file, editorConnector);
				} else {
					IJavaTextResource resource = (IJavaTextResource) editorConnector.getModel().eResource();
					resource.unload();
					try {
						resource.load(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}
					CompilationUnit compilationUnit = (CompilationUnit) resource.getContents().get(0);
					editorConnector.setModel(compilationUnit);
				}
				if(!editorConnector.getEditor().equals(textEditor)){
					editorConnector.setEditor(textEditor);
				}
				return editorConnector;
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
