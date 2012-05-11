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
package org.eclipse.xtext.refactoring.editorconnector;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.emftext.refactoring.editorconnector.IEditorConnector;

public class XtextEditorConnector implements IEditorConnector {

	private XtextEditor editor;
	private EObjectAtOffsetHelper objectAtOffsetHelper;
	private ILocationInFileProvider locationInFileProvider;
	private Resource resource;

	public XtextEditorConnector() {
		//
	}

	public boolean canHandle(IEditorPart editor) {
		if(editor == null){
			return false;
		}
		if(editor instanceof XtextEditor){
			this.editor = (XtextEditor) editor;
			IXtextDocument doc = XtextDocumentUtil.get(editor);
			resource = doc.modify(new IUnitOfWork<Resource, XtextResource>() {

				public Resource exec(XtextResource state) throws Exception {
					IResourceServiceProvider resourceServiceProvider = state.getResourceServiceProvider();
					objectAtOffsetHelper = resourceServiceProvider.get(EObjectAtOffsetHelper.class);
					locationInFileProvider = resourceServiceProvider.get(ILocationInFileProvider.class);
					return state;
				}
			});
//			XtextResource resource = getXtextResource(this.editor);
//			IResourceServiceProvider resourceServiceProvider = resource.getResourceServiceProvider();
//			objectAtOffsetHelper = resourceServiceProvider.get(EObjectAtOffsetHelper.class);
//			locationInFileProvider = resourceServiceProvider.get(ILocationInFileProvider.class);
			if(objectAtOffsetHelper != null && locationInFileProvider != null){
				return true;
			}
		}
		return false;
	}

	public List<EObject> handleSelection(final ISelection selection) {
		IXtextDocument doc = XtextDocumentUtil.get(editor);
		List<EObject> selectedElements = doc.modify(new IUnitOfWork<List<EObject>, XtextResource>() {

			public List<EObject> exec(XtextResource state) throws Exception {
				System.out.println(state);
				if(selection instanceof ITextSelection){
					ITextSelection textSelection = (ITextSelection) selection;
					Set<EObject> elementSet = new LinkedHashSet<EObject>();
					int offset = textSelection.getOffset();
					for (int i = (textSelection.getLength() == 0 ? 1 : textSelection.getLength()); i > 0; i--) {
						EObject element = objectAtOffsetHelper.resolveElementAt(state, offset);
						elementSet.add(element);
						offset++;
					}
					List<EObject> nonProxyElements = new LinkedList<EObject>();
					for (EObject object : elementSet) {
						if(!object.eIsProxy()){
							nonProxyElements.add(object);
						}
					}
					return nonProxyElements;
				}
				return null;
			}
		});
		return selectedElements;
//		if(selection instanceof ITextSelection){
//			resource = getXtextResource(editor);
//			System.out.println(resource);
//			if(resource instanceof XtextResource){
//				XtextResource xtextResource = (XtextResource) resource;
//				ITextSelection textSelection = (ITextSelection) selection;
//				Set<EObject> elementSet = new LinkedHashSet<EObject>();
//				int offset = textSelection.getOffset();
//				for (int i = textSelection.getLength(); i > 0; i--) {
//					EObject element = objectAtOffsetHelper.resolveElementAt(xtextResource, offset);
//					elementSet.add(element);
//					offset++;
//				}
//				List<EObject> nonProxyElements = new LinkedList<EObject>();
//				for (EObject object : elementSet) {
//					if(!object.eIsProxy()){
//						nonProxyElements.add(object);
//					}
//				}
//				return nonProxyElements;
//			}
//		}
//		return null;
	}

	private XtextResource getXtextResource(XtextEditor editor){
		IXtextDocument doc = XtextDocumentUtil.get(editor);
		XtextResource resource;
		resource = doc.modify(new IUnitOfWork<XtextResource, XtextResource>() {

			public XtextResource exec(XtextResource state) throws Exception {
				return state;
			}

		});
		return resource;
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return null;
	}

	public void selectEObjects(final List<EObject> objectsToSelect) {
		IXtextDocument doc = XtextDocumentUtil.get(editor);
		doc.modify(new IUnitOfWork<String, XtextResource>() {

			public String exec(XtextResource state) throws Exception {
//				URI uri = resource.getURI();
//				String pathString = uri.toPlatformString(true);
//				IPath path = Path.fromOSString(pathString);
//				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
//				IEditorInput editorInput = new FileEditorInput(file);
//				editor.setInput(editorInput);
				int offset = Integer.MAX_VALUE;
				int length = 0;
				for (EObject object : objectsToSelect) {
					ITextRegion textRegion = locationInFileProvider.getFullTextRegion(object);
					if (textRegion.getOffset() < offset){
						if(length != 0){
							length += offset - textRegion.getOffset();
						} else {
							length = textRegion.getLength();
						}
						offset = textRegion.getOffset();
					}
				}
				if(length != 0){
					editor.selectAndReveal(offset, length);
				}

				return null;
			}
		});
	}

}
