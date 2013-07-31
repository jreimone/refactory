package org.emftext.incquery.modelconnector;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IModelConnectorTypeEnum;
import org.eclipse.incquery.tooling.ui.queryexplorer.adapters.EMFModelConnector;
import org.eclipse.ui.texteditor.ITextEditor;
import org.emftext.access.resource.IEditor;
import org.emftext.access.resource.ILocationMap;
import org.emftext.access.resource.IResource;

public class EMFTextModelConnector extends EMFModelConnector {

	private IEditor emftextEditor;
	private ITextEditor textEditor;

	public EMFTextModelConnector(ITextEditor textEditor, IEditor emftextEditor) {
		super(textEditor);
		this.emftextEditor = emftextEditor;
		this.textEditor = textEditor;
	}

	@Override
	public Notifier getNotifier(IModelConnectorTypeEnum modelConnectorTypeEnum) {
		Notifier result = null;
		switch (modelConnectorTypeEnum) {
		case RESOURCE:
			result = emftextEditor.getResource();
			break;
			
		case RESOURCESET:
			result = emftextEditor.getResource().getResourceSet();
			
		}
		return result;
	}

	@Override
	public void showLocation(Object[] locationObjects) {
		IResource emftextResource = emftextEditor.getResource();
		ILocationMap locationMap = emftextResource.getLocationMap();
		if (locationObjects.length > 0 && objectsAreEObjects(locationObjects)) {
			// selects the first object in the array since text editors can only select one
			EObject eObject = (EObject) locationObjects[0];
			int start = locationMap.getCharStart(eObject);
			int end = locationMap.getCharEnd(eObject);
			textEditor.selectAndReveal(start, end - start + 1);
		} 
	}

	private boolean objectsAreEObjects(Object[] locationObjects) {
		if(locationObjects == null){
			return false;
		}
		for (Object object : locationObjects) {
			if(!(object instanceof EObject)){
				return false;
			}
		}
		return true;
	}
}
