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
import org.emftext.language.refactoring.rolemapping.RoleMappingModel;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class UnregisterRoleMappingModelHandler extends RegisterRoleMappingModelHandler {

	@Override
	protected void executeWithModelInTextEditor(RoleMappingModel model) {
		List<RoleMapping> ununregisteredRoleMappings = IRoleMappingRegistry.INSTANCE.unregisterRoleMappings(model);
		String roleMappings = "";
		if(ununregisteredRoleMappings != null && ununregisteredRoleMappings.size() > 0){
			for (RoleMapping roleMapping : ununregisteredRoleMappings) {
				roleMappings += roleMapping.getName() + ", "; 
			}
			roleMappings = roleMappings.substring(0, roleMappings.length() - 2);
			UIUtil.showToolTip("Unregistering RoleMappings"
					, "The following role mapping(s) couldn't be unregistered because they never were registered:\n\n" + roleMappings
					, getEditor());
		}
		//TODO unregister all corresponding refspecs, rolemappings
	}
}
