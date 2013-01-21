package dk.itu.sdg.aspect.tracemodel.generator;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

public class AspectGeneratorModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		return "dk.itu.sdg.aspect.tracemodel.generator.presentation.NoEditorID";
	}

	@Override
	protected String getFileExtensions() {
		return "ecore";
	}

	public Class<? extends IGenerator2> bindIGenerator() {
		return AspectGenerator.class;
	}

	public Class<? extends ResourceSet> bindResourceSet() {
		return ResourceSetImpl.class;
	}

}
