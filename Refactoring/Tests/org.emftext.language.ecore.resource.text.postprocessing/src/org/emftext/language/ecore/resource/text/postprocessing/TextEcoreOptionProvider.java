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
