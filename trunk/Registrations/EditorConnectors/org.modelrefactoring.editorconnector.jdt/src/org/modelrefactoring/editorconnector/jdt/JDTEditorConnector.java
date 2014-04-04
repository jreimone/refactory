package org.modelrefactoring.editorconnector.jdt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.resource.java.IJavaLocationMap;
import org.emftext.language.java.resource.java.IJavaTextResource;
import org.emftext.refactoring.editorconnector.IEditorConnector;

public class JDTEditorConnector implements IEditorConnector {

	private ITextEditor jdtEditor;
	private IFile file;
	private IJavaTextResource resource;
	private CompilationUnit javaModel;

	public JDTEditorConnector(ITextEditor jdtEditor, IJavaTextResource resource) {
		this.resource = resource;
		this.jdtEditor = jdtEditor;
		javaModel = (CompilationUnit) resource.getContents().get(0);
	}

	private void initResource(){
		if(resource == null){
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			ResourceSet rs = new ResourceSetImpl();
			resource = (IJavaTextResource) rs.getResource(uri, true);
			javaModel = (CompilationUnit) resource.getContents().get(0);
		}
	}
	
	@Override
	public List<EObject> handleSelection(ISelection selection) {
		initResource();
		IJavaLocationMap locationMap = resource.getLocationMap();
		ITextSelection textSelection = (ITextSelection) selection;
		int startOffset = textSelection.getOffset();
		int endOffset = startOffset + textSelection.getLength();
		List<EObject> selectedElements = new LinkedList<EObject>();
		List<EObject> noReferencesList = new ArrayList<EObject>();
		if (startOffset == endOffset) {
			selectedElements = locationMap.getElementsAt(startOffset);
			if(selectedElements.size() > 0){
				EObject nearestObject = selectedElements.get(0);
				if (!nearestObject.eIsProxy()) {
					noReferencesList.add(nearestObject);
				}
			}
		} else {
			selectedElements = locationMap.getElementsBetween(startOffset, endOffset);
			for (EObject object : selectedElements) {
				EcoreUtil.resolveAll(object);
				int start = locationMap.getCharStart(object);
				int end = locationMap.getCharEnd(object);
				if ((start >= startOffset && end <= endOffset) && !object.eIsProxy()) {
					noReferencesList.add(object);
				}
			}
		}
		return noReferencesList;
	}

	@Override
	public EditingDomain getTransactionalEditingDomain() {
		return null;
	}

	@Override
	public void selectEObjects(List<EObject> objectsToSelect) {
		initResource();
		try {
			IJavaLocationMap locationMap = resource.getLocationMap();
			if (objectsToSelect.size() > 0) {
				EObject eObject = objectsToSelect.get(0);
				int start = locationMap.getCharStart(eObject);
				int end = locationMap.getCharEnd(eObject);
				jdtEditor.selectAndReveal(start, end - start + 1);
			} else {
				int startOffset = ((ITextSelection) jdtEditor.getSelectionProvider().getSelection()).getOffset();
				EObject nearestObject = locationMap.getElementsAt(startOffset).get(
						0);
				startOffset = locationMap.getCharStart(nearestObject);
				int endOffset = locationMap.getCharEnd(nearestObject);
				int length = endOffset - startOffset + 1;
				jdtEditor.selectAndReveal(startOffset, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public EObject getModel() {
		initResource();
		return javaModel;
	}

	@Override
	public void setMarkingForEObject(EObject element, IMarker marker) {
		initResource();
		IJavaLocationMap locationMap = resource.getLocationMap();
		if(element.eIsProxy()){
			ResourceSet resourceSet = resource.getResourceSet();
			element = EcoreUtil.resolve(element, resourceSet);
		}
		int start = locationMap.getCharStart(element);
		int end = locationMap.getCharEnd(element);
		int line = locationMap.getLine(element);
		if(start != -1 && end != -1 && line != -1){
			try {
				marker.setAttribute(IMarker.LINE_NUMBER, line);
				marker.setAttribute(IMarker.CHAR_START, start);
				marker.setAttribute(IMarker.CHAR_END, end);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public IEditorPart getEditor() {
		return jdtEditor;
	}

	protected void setEditor(ITextEditor jdtEditor) {
		this.jdtEditor = jdtEditor;
	}

	protected void setModel(CompilationUnit javaModel) {
		this.javaModel = javaModel;
	}
}
