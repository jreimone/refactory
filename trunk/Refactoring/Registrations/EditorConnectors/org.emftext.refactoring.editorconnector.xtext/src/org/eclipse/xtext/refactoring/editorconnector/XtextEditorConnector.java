package org.eclipse.xtext.refactoring.editorconnector;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.TextLocation;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.emftext.refactoring.editorconnector.IEditorConnector;

public class XtextEditorConnector implements IEditorConnector {

	private XtextEditor editor;

	public XtextEditorConnector() {
		//
	}

	public boolean canHandle(IEditorPart editor) {
		if(editor instanceof XtextEditor){
			this.editor = (XtextEditor) editor;
			return true;
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
					EObject element = EObjectAtOffsetHelper.resolveContainedElementAt(xtextResource, offset, null);
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
			EReference containmentFeature = object.eContainmentFeature();
			TextLocation location = EObjectAtOffsetHelper.getLocation(object, containmentFeature, 0);
			if (location.getOffset() < offset){
				if(length != 0){
					length += offset - location.getOffset();
				} else {
					length = location.getLength();
				}
				offset = location.getOffset();
			}
		}
		if(length != 0){
			editor.selectAndReveal(offset, length);
		}
	}

}
