package org.eclipse.gmf.refactoring.editorconnector;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.emftext.refactoring.editorconnector.IEditorConnector;

public class GMFEditorConnectorAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if(adapterType.equals(IEditorConnector.class) && adaptableObject instanceof DiagramDocumentEditor){
			DiagramDocumentEditor documentEditor = (DiagramDocumentEditor) adaptableObject;
			DiagramEditPart editPart = documentEditor.getDiagramEditPart();
			if(editPart.getModel() instanceof View){
				EObject model = EcoreUtil.getRootContainer(((View) editPart.getModel()).getElement());
				if(model != null){
					return new GMFEditorConnector(documentEditor);
				}
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
