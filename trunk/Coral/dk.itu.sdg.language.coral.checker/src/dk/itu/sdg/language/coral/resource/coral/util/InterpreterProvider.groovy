package dk.itu.sdg.language.coral.resource.coral.util

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import dk.itu.sdg.language.coral.Relation;
import dk.itu.sdg.language.coral.resource.coral.ICoralOptionProvider
import dk.itu.sdg.language.coral.resource.coral.ICoralOptions
import dk.itu.sdg.language.coral.resource.coral.ICoralResourcePostProcessor
import dk.itu.sdg.language.coral.resource.coral.ICoralResourcePostProcessorProvider
import dk.itu.sdg.language.coral.resource.coral.mopp.CoralResource

public class InterpreterProvider implements ICoralOptionProvider, ICoralResourcePostProcessorProvider, ICoralResourcePostProcessor {

	public Map<?, ?> getOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ICoralOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}

	public ICoralResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void process(CoralResource resource) {
		CoralInterpreter interpreter = new CoralInterpreter()
		Object context = null
		
		TreeIterator<EObject> contents = resource.getAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof Relation) {
				if (((Relation)next).isInterpreted()) {
					interpreter.addObjectToInterprete(next);
				}
			}
		}
		interpreter.interprete(context);
	}

	public void terminate() {
		// do nothing
	}
}
