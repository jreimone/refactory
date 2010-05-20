package org.emftext.refactoring.editorconnector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IEditor;
import org.emftext.access.resource.ILocationMap;
import org.emftext.access.resource.IResource;
import org.emftext.refactoring.editorconnector.IEditorConnector;
import org.osgi.framework.Version;

public class EMFTextEditorConnector implements IEditorConnector {

	private static final String MIN_VERSION = "1.3.0";

	private IEditorPart editor;

	public EMFTextEditorConnector() {
		// empty
	}

	public boolean canHandle(IEditorPart editor) {
		this.editor = editor;
		Version emftextVersion = EMFTextAccessPlugin.getDefault().getBundle().getVersion();
		Version minVersion = new Version(MIN_VERSION);
		if(emftextVersion.compareTo(minVersion) < 0){
			try {
				IEditor emftextEditor = (IEditor) EMFTextAccessProxy.get(editor, IEditor.class);
				IResource emftextResource = emftextEditor.getResource();
				if(emftextResource != null){
					return true;
				}
				return false;
			} catch (Exception e) {
				// could not handle
				return false;
			}
		} else {
			return EMFTextAccessProxy.isAccessibleWith(editor.getClass(), IEditor.class);
		}
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
		try {
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
		} catch (Exception e) {
			// methods could not be invoked via EMFTextAccessProxy
			IStatus status = new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Could not select objects after refactoring in editor: " + editor);
			Activator.getDefault().getLog().log(status);
		}
	}

}
