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
	protected void executeWithModelInTextEditor(RoleMapping model) {
		List<RoleMapping> registeredRoleMappings = IRoleMappingRegistry.INSTANCE.registerRoleMapping(model);
		if(registeredRoleMappings != null && registeredRoleMappings.size() > 0){
			UIUtil.showToolTip("Registering RoleMappings"
					, "The role mapping '" + model.getName() + "' couldn't be registered because it already was."
					, getEditor());
		}
	}

	@Override
	protected RoleMapping getModelFromSelection(ITextSelection selection, IRolemappingTextResource resource) {
		IRolemappingLocationMap locationMap = resource.getLocationMap();
		EObject nearestObject = null;
		List<EObject> selectedElements = locationMap.getElementsAt(selection.getOffset());
		for (EObject element : selectedElements) {
			if(!element.eIsProxy()){
				nearestObject = element;
				break;
			}
		}
		while(nearestObject != null && !(nearestObject instanceof RoleMapping)){
			nearestObject = nearestObject.eContainer();
		}
		return (RoleMapping) nearestObject;
	}

}
