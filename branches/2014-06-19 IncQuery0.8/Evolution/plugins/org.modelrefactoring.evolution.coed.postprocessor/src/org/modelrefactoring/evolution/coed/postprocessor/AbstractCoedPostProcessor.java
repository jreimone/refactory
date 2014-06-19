package org.modelrefactoring.evolution.coed.postprocessor;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.modelrefactoring.evolution.coed.CoEvolutionDefinition;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedResourcePostProcessor;
import org.modelrefactoring.evolution.coed.resource.coed.ICoedResourcePostProcessorProvider;
import org.modelrefactoring.evolution.coed.resource.coed.mopp.CoedResource;

public abstract class AbstractCoedPostProcessor implements ICoedResourcePostProcessorProvider, ICoedResourcePostProcessor {

	@Override
	public void process(CoedResource resource) {
		List<EObject> contents = resource.getContents();
		for (EObject model : contents) {
			if(model instanceof CoEvolutionDefinition){
				process(resource, (CoEvolutionDefinition) model);
			}
		}
	}

	public abstract void process(CoedResource resource, CoEvolutionDefinition model);

	@Override
	public void terminate() {
		// do nothing
	}

	@Override
	public ICoedResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

}
