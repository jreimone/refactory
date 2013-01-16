 
package org.emftext.refactoring.smelltype.registry;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.emftext.refactoring.smelltype.SmellType;
import org.emftext.refactoring.smelltype.SmellTypeModel;
import org.emftext.refactoring.smelltype.SmelltypeFactory;

@SuppressWarnings("restriction")
public class SmellTypeRegistry {
	
	@PostConstruct
	void initRegistry(IEclipseContext context, IExtensionRegistry registry) {
		SmellTypeModel smellTypeModel = initSmellTypeModel(registry);
		context.set(SmellTypeModel.class, smellTypeModel);
	}

	private SmellTypeModel initSmellTypeModel(IExtensionRegistry registry) {
		SmellTypeModel model = SmelltypeFactory.eINSTANCE.createSmellTypeModel();
		if(registry != null){
			IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(ISmellTypeExtensionPoint.ID);
			if(elements != null){
				for (IConfigurationElement element : elements) {
					try {
						SmellType smellType = (SmellType) element.createExecutableExtension(ISmellTypeExtensionPoint.smellTypeClass);
						if(smellType != null){
							model.getTypes().add(smellType);
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return model;
	}
	
}