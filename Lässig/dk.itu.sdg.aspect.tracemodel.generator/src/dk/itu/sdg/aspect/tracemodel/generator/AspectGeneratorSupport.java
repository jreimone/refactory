package dk.itu.sdg.aspect.tracemodel.generator;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

public class AspectGeneratorSupport extends AbstractGenericResourceSupport {

	@Override
	protected Module createGuiceModule() {
		return new AspectGeneratorModule();
	}

}


