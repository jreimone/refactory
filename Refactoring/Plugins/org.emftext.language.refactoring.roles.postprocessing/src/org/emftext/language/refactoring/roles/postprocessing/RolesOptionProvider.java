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
package org.emftext.language.refactoring.roles.postprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextOptionProvider;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextOptions;
import org.emftext.language.refactoring.roles.resource.rolestext.IRolestextResourcePostProcessorProvider;

public class RolesOptionProvider implements IRolestextOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		
		List<IRolestextResourcePostProcessorProvider> postProcessors = new ArrayList<IRolestextResourcePostProcessorProvider>();
		postProcessors.add(new RoleModifierAnalyser());
		postProcessors.add(new RelationModifierAnalyser());
		postProcessors.add(new DistinctRelationNamesAnalyser());
		postProcessors.add(new DistinctRoleNamesAnalyser());
		
		options.put(IRolestextOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		return options;
	}

}
