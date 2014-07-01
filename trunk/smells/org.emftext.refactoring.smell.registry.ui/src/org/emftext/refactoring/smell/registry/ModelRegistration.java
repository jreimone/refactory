package org.emftext.refactoring.smell.registry;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;

public class ModelRegistration {

	@Execute
	public void register(IEclipseContext context, IWorkspace workspace, IExtensionRegistry registry) {
		IQualitySmellModelInitializer initializer = new ExtensionRegistryQualitySmellModelInitializer(context, workspace, registry);
		IQualitySmellRegistry.INSTANCE.setInitializer(initializer);
	}
}
