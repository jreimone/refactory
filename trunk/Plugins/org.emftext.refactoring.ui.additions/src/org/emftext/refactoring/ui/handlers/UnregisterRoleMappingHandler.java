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

import org.emftext.language.refactoring.rolemapping.RoleMapping;
import org.emftext.refactoring.registry.rolemapping.IRoleMappingRegistry;

public class UnregisterRoleMappingHandler extends RegisterRoleMappingHandler {

	@Override
	protected void executeWithModelInTextEditor(RoleMapping model) {
		RoleMapping unregisteredMapping = IRoleMappingRegistry.INSTANCE.unregisterRoleMapping(model);
		if(unregisteredMapping == null){
			UIUtil.showToolTip("Unregistering RoleMapping"
					, "The role mapping '" + model.getName() + "' couldn't be unregistered because it wasn't registered."
					, getEditor());
		}
	}

}
