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
		
		options.put(IRolestextOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		return options;
	}

}
