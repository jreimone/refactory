package org.qualitune.guery.postprocessor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.qualitune.guery.MotifModel;
import org.qualitune.guery.resource.guery.IGueryResourcePostProcessor;
import org.qualitune.guery.resource.guery.IGueryResourcePostProcessorProvider;
import org.qualitune.guery.resource.guery.mopp.GueryResource;

public abstract class AbstractGueryPostProcessor implements IGueryResourcePostProcessorProvider, IGueryResourcePostProcessor {

	@Override
	public void process(GueryResource resource) {
		EList<EObject> contents = resource.getContents();
		for (EObject model : contents) {
			if(model instanceof MotifModel){
				process(resource, (MotifModel) model);
			}
		}
	}
	
	public abstract void process(GueryResource resource, MotifModel model);

	@Override
	public void terminate() {
		// do nothing
	}

	@Override
	public IGueryResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

}
