package org.emftext.refactoring.ui.handlers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingLocationMap;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingTextResource;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui.RolemappingEditor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class RegisterRoleMappingHandler extends AbstractModelHandler<RoleMapping, IRolemappingTextResource, RolemappingEditor> {

	@Override
	protected boolean isModelEditorInstance(IEditorPart editor) {
		return editor instanceof RolemappingEditor;
	}

	@Override
	protected IRolemappingTextResource getResource(RolemappingEditor editor) {
		return editor.getResource();
	}

	@Override
	protected void registerModel(RoleMapping model) {
		IRoleMappingRegistry.INSTANCE.registerRoleMapping(model);
	}

	@Override
	protected RoleMapping getModelFromSelection(ITextSelection selection, IRolemappingTextResource resource) {
		IRolemappingLocationMap locationMap = resource.getLocationMap();
		List<EObject> selectedElements = locationMap.getElementsAt(selection.getOffset());
		EObject nearestObject = selectedElements.get(0);
		while(!(nearestObject instanceof RoleMapping) && nearestObject != null){
			nearestObject = nearestObject.eContainer();
		}
		return (RoleMapping) nearestObject;
	}

}
