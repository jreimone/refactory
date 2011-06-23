package org.eclipse.xtext.refactoring.editorconnector;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
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

	public XtextEditorConnector() {
		//
	}

	public boolean canHandle(IEditorPart editor) {
		if(editor instanceof XtextEditor){
			this.editor = (XtextEditor) editor;
			XtextResource resource = getXtextResource(this.editor);
			IResourceServiceProvider resourceServiceProvider = resource.getResourceServiceProvider();
			objectAtOffsetHelper = resourceServiceProvider.get(EObjectAtOffsetHelper.class);
			locationInFileProvider = resourceServiceProvider.get(ILocationInFileProvider.class);
			if(objectAtOffsetHelper != null && locationInFileProvider != null){
				return true;
			}
		}
		return false;
	}

	public List<EObject> handleSelection(ISelection selection) {
		if(selection instanceof ITextSelection){
			Resource resource = getXtextResource(editor);
			System.out.println(resource);
			if(resource instanceof XtextResource){
				XtextResource xtextResource = (XtextResource) resource;
				ITextSelection textSelection = (ITextSelection) selection;
				Set<EObject> elementSet = new LinkedHashSet<EObject>();
				int offset = textSelection.getOffset();
				for (int i = textSelection.getLength(); i > 0; i--) {
					EObject element = objectAtOffsetHelper.resolveElementAt(xtextResource, offset);
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
		}
		return null;
	}

	private XtextResource getXtextResource(XtextEditor editor){
		IXtextDocument doc = XtextDocumentUtil.get(editor);
		XtextResource resource;
		resource = doc.readOnly(new IUnitOfWork<XtextResource, XtextResource>() {

			public XtextResource exec(XtextResource state) throws Exception {
				return state;
			}

		});
		return resource;
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return null;
	}

	public void selectEObjects(List<EObject> objectsToSelect) {
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
	}

}
