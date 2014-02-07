package org.modelrefactoring.evolution.coed.postprocessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelrefactoring.evolution.coed.resource.coed.ICoedOptionProvider;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedOptions;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedResourcePostProcessorProvider;

public class CoedOptionProvider implements ICoedOptionProvider {

	@Override
	public Map<?, ?> getOptions() {
		Map<String, List<ICoedResourcePostProcessorProvider>> map = new HashMap<String, List<ICoedResourcePostProcessorProvider>>();
		List<ICoedResourcePostProcessorProvider> providers = new ArrayList<ICoedResourcePostProcessorProvider>();
		providers.add(new MVELExpressionPostProcessor());
		map.put(ICoedOptions.RESOURCE_POSTPROCESSOR_PROVIDER, providers);
		return map;
	}

}
