/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.refactoring.editorconnector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.access.resource.IEditor;
import org.emftext.access.resource.ILocationMap;
import org.emftext.access.resource.IResource;

public class EMFTextEditorConnector implements IEditorConnector {

	private ITextEditor textEditor;
	private IEditor emftextEditor;

	protected EMFTextEditorConnector(ITextEditor textEditor, IEditor emftextEditor) {
		this.textEditor = textEditor;
		this.emftextEditor = emftextEditor;
	}

	public List<EObject> handleSelection(ISelection selection) {
		if(emftextEditor == null){
			return null;
		}
		IResource emftextResource = emftextEditor.getResource();
		ILocationMap locationMap = emftextResource.getLocationMap();
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

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return null;
	}

	public void selectEObjects(List<EObject> objectsToSelect) {
		try {
			IResource emftextResource = emftextEditor.getResource();
			ILocationMap locationMap = emftextResource.getLocationMap();
			if (objectsToSelect.size() > 0) {
				EObject eObject = objectsToSelect.get(0);
				int start = locationMap.getCharStart(eObject);
				int end = locationMap.getCharEnd(eObject);
				textEditor.selectAndReveal(start, end - start + 1);
			} else {
				int startOffset = ((ITextSelection) textEditor.getSelectionProvider().getSelection()).getOffset();
				EObject nearestObject = locationMap.getElementsAt(startOffset).get(
						0);
				startOffset = locationMap.getCharStart(nearestObject);
				int endOffset = locationMap.getCharEnd(nearestObject);
				int length = endOffset - startOffset + 1;
				textEditor.selectAndReveal(startOffset, length);
			}
		} catch (Exception e) {
			// methods could not be invoked via EMFTextAccessProxy
//			Bundle bundle = FrameworkUtil.getBundle(this.getClass());
//			String symbolicName = bundle.getSymbolicName();
//			IStatus status = new Status(IStatus.WARNING, symbolicName, "Could not select objects after refactoring in editor: " + textEditor);
//			Activator.getDefault().getLog().log(status);
			e.printStackTrace();
		}
	}

	@Override
	public EObject getModel() {
		if(emftextEditor == null){
			return null;
		}
		IResource emftextResource = emftextEditor.getResource();
		EObject model = emftextResource.getContents().get(0);
		return model;
	}

	@Override
	public void setMarkingForEObject(EObject element, IMarker marker) {
		IResource emftextResource = emftextEditor.getResource();
		ILocationMap locationMap = emftextResource.getLocationMap();
		if(element.eIsProxy()){
			ResourceSet resourceSet = emftextResource.getResourceSet();
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
		return textEditor;
	}

}
