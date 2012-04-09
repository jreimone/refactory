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
package org.emftext.language.ecore.resource.text.postprocessing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.emftext.language.ecore.resource.text.ITextEcoreOptionProvider;
import org.emftext.language.ecore.resource.text.ITextEcoreOptions;
import org.emftext.language.ecore.resource.text.ITextEcoreResourcePostProcessorProvider;

public class TextEcoreOptionProvider implements ITextEcoreOptionProvider {

	public TextEcoreOptionProvider() {
		super();
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		
		List<ITextEcoreResourcePostProcessorProvider> postProcessors = new LinkedList<ITextEcoreResourcePostProcessorProvider>();
		postProcessors.add(new SameAttributesInHierarchyAnalyser());
		
		options.put(ITextEcoreOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		return options;
	}

}
