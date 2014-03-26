package org.emftext.refactoring.editorconnector;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IEditor;

public class EMFTextEditorConnectorAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if(adapterType.equals(IEditorConnector.class) && adaptableObject instanceof ITextEditor){
			ITextEditor textEditor = (ITextEditor) adaptableObject;
			if(EMFTextAccessProxy.isAccessibleWith(textEditor.getClass(), IEditor.class)){
				IEditor emftextEditor = (IEditor) EMFTextAccessProxy.get(adaptableObject, IEditor.class);
				return new EMFTextEditorConnector(textEditor, emftextEditor);
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
