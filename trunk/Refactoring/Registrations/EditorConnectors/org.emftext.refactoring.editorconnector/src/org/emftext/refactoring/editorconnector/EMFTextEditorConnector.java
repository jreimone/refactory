package org.emftext.refactoring.editorconnector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IEditor;
import org.emftext.access.resource.ILocationMap;
import org.emftext.access.resource.IResource;
import org.emftext.refactoring.editorconnector.IEditorConnector;

public class EMFTextEditorConnector implements IEditorConnector {

	private IEditorPart editor;

	public EMFTextEditorConnector() {
		// empty
	}

	public boolean canHandle(IEditorPart editor) {
		this.editor = editor;
		return EMFTextAccessProxy.isAccessibleWith(editor.getClass(), IEditor.class);
	}

	public List<EObject> handleSelection(ISelection selection) {
		IEditor emftextEditor = (IEditor) EMFTextAccessProxy.get(editor, IEditor.class);
		IResource emftextResource = emftextEditor.getResource();
		ILocationMap locationMap = emftextResource.getLocationMap();
		ITextSelection textSelection = (ITextSelection) selection;
		int startOffset = textSelection.getOffset();
		int endOffset = startOffset + textSelection.getLength();
		List<EObject> selectedElements = new LinkedList<EObject>();
		if(startOffset == endOffset){
			selectedElements = locationMap.getElementsAt(startOffset);
		} else {
			selectedElements = locationMap.getElementsBetween(startOffset, endOffset);
		}
		List<EObject> noReferencesList = new ArrayList<EObject>();
		for (EObject object : selectedElements) {
			EcoreUtil.resolveAll(object);
			int start = locationMap.getCharStart(object);
			int end = locationMap.getCharEnd(object);
			if((start >= startOffset && end <= endOffset) && !object.eIsProxy()){
				noReferencesList.add(object);
			}
		}
		return noReferencesList;
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return null;
	}

	public void selectEObjects(List<EObject> objectsToSelect) {
		IEditor emftextEditor = (IEditor) EMFTextAccessProxy.get(editor, IEditor.class);
		IResource emftextResource = emftextEditor.getResource();
		ILocationMap locationMap = emftextResource.getLocationMap();
		if(objectsToSelect.size() > 0){
			EObject eObject = objectsToSelect.get(0);
			int start = locationMap.getCharStart(eObject);
			int end = locationMap.getCharEnd(eObject);
			((ITextEditor) editor).selectAndReveal(start, end - start);
		} else {
			int offset = ((ITextSelection) ((ITextEditor) editor).getSelectionProvider().getSelection()).getOffset();
			((ITextEditor) editor).selectAndReveal(offset, 0);
		}
	}

}
