package org.qualitune.guery.postprocessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.qualitune.guery.resource.guery.IGueryOptionProvider;
import org.qualitune.guery.resource.guery.IGueryOptions;
import org.qualitune.guery.resource.guery.IGueryResourcePostProcessorProvider;

public class GueryOptionProvider implements IGueryOptionProvider {


	@Override
	public Map<?, ?> getOptions() {
		Map<String, List<IGueryResourcePostProcessorProvider>> map = new HashMap<String, List<IGueryResourcePostProcessorProvider>>();
		List<IGueryResourcePostProcessorProvider> providers = new ArrayList<IGueryResourcePostProcessorProvider>();
		providers.add(new MVELValidationPostProcessor());
		map.put(IGueryOptions.RESOURCE_POSTPROCESSOR_PROVIDER, providers);
		return map;
	}

}
