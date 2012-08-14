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

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.IEditorPart;
import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingTextResource;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.ui.RolemappingEditor;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class RegisterRoleMappingModelHandler extends AbstractModelHandler<RoleMappingModel, IRolemappingTextResource, RolemappingEditor> {

	@Override
	protected boolean isModelEditorInstance(IEditorPart editor) {
		return editor instanceof RolemappingEditor;
	}

	@Override
	protected IRolemappingTextResource getResource(RolemappingEditor editor) {
		return editor.getResource();
	}

	@Override
	protected void executeWithModelInTextEditor(RoleMappingModel model) {
		List<RoleMapping> registeredRoleMappings = IRoleMappingRegistry.INSTANCE.registerRoleMappingModel(model);
		if(registeredRoleMappings != null && registeredRoleMappings.size() > 0){
			String roleMappings = "";
			for (RoleMapping roleMapping : registeredRoleMappings) {
				roleMappings += roleMapping.getName() + ", ";
			}
			roleMappings = roleMappings.substring(0, roleMappings.length() - 2);
			UIUtil.showToolTip("Registering RoleMappings"
					, "The following role mapping(s) couldn't be registered because they already were:\n\n" + roleMappings
					, getEditor());
		}
	}

	@Override
	protected RoleMappingModel getModelFromSelection(ITextSelection selection, IRolemappingTextResource resource) {
		return (RoleMappingModel) resource.getContents().get(0);
	}

}
