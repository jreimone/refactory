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

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;
import org.emftext.refactoring.registry.rolemodel.IRoleModelRegistry;

public class UnregisterRoleModelHandler extends RegisterRoleModelHandler {

	@Override
	protected void executeWithModelInTextEditor(RoleModel model) {
		RoleModel unregisterRoleModel = IRoleModelRegistry.INSTANCE.unregisterRoleModel(model);
		List<RoleMapping> mappingsForRoleModel = IRoleMappingRegistry.INSTANCE.getRoleMappingsForRoleModel(unregisterRoleModel);
		if(mappingsForRoleModel != null){
			for (RoleMapping roleMapping : mappingsForRoleModel) {
				IRoleMappingRegistry.INSTANCE.unregisterRoleMapping(roleMapping);
			}
		}
		if(unregisterRoleModel == null){
			UIUtil.showToolTip("Unregistering RoleModel"
					, "RoleModel '" + model.getName() + "' couldn't be unregistered.\nIt never was registered."
					, getEditor());
		}
	}

	@Override
	protected void executeWithRoleModelInGMFEditor(RoleModel roleModel) {
		RoleModel unregisteredRoleModel = IRoleModelRegistry.INSTANCE.unregisterRoleModel(roleModel);
		List<RoleMapping> mappingsForRoleModel = IRoleMappingRegistry.INSTANCE.getRoleMappingsForRoleModel(unregisteredRoleModel);
		if(mappingsForRoleModel != null){
			for (RoleMapping roleMapping : mappingsForRoleModel) {
				IRoleMappingRegistry.INSTANCE.unregisterRoleMapping(roleMapping);
			}
		}
		if(unregisteredRoleModel == null){
			UIUtil.showToolTip("Untegistering RoleModel"
					, "RoleModel '" + roleModel.getName() + "' couldn't be unregistered.\nIt never was registered."
					, getEditor());
		}
	}
}
