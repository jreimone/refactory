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
/**
 * 
 */
package org.emftext.language.refactoring.rolemapping.postprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingOptionProvider;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingOptions;
import org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingResourcePostProcessorProvider;

/**
 * OptionProvider for adding new postprocessors.
 * 
 * @author Jan Reimann
 *
 */
public class RoleMappingOptionProvider implements IRolemappingOptionProvider {

	/* (non-Javadoc)
	 * @see org.emftext.language.refactoring.rolemapping.resource.rolemapping.IRolemappingOptionProvider#getOptions()
	 */
	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		
		List<IRolemappingResourcePostProcessorProvider> postProcessors = new ArrayList<IRolemappingResourcePostProcessorProvider>();
		postProcessors.add(new ConcreteMappingAnalyser());
//		postProcessors.add(new RelationMappingAnalyser());
		postProcessors.add(new RoleConstraintAnalyser());
		
//		postProcessors.add(new ProxyResolver());
		
		options.put(IRolemappingOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		return options;
	}

}
