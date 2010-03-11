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
