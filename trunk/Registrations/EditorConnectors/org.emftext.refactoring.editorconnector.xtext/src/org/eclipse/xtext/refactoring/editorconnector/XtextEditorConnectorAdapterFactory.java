package org.eclipse.xtext.refactoring.editorconnector;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.emftext.refactoring.editorconnector.IEditorConnector;

public class XtextEditorConnectorAdapterFactory implements IAdapterFactory {

	private ILocationInFileProvider locationInFileProvider;
	private EObjectAtOffsetHelper objectAtOffsetHelper;

	@Override
	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if(adapterType.equals(IEditorConnector.class) && adaptableObject instanceof XtextEditor){
			XtextEditor editor = (XtextEditor) adaptableObject;
			IXtextDocument doc = XtextDocumentUtil.get(editor);
			Resource resource = doc.modify(new IUnitOfWork<Resource, XtextResource>() {

				public Resource exec(XtextResource state) throws Exception {
					IResourceServiceProvider resourceServiceProvider = state.getResourceServiceProvider();
					objectAtOffsetHelper = resourceServiceProvider.get(EObjectAtOffsetHelper.class);
					locationInFileProvider = resourceServiceProvider.get(ILocationInFileProvider.class);
					return state;
				}
			});
			if(objectAtOffsetHelper != null && locationInFileProvider != null){
				return new XtextEditorConnector(editor, resource, objectAtOffsetHelper, locationInFileProvider);
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
