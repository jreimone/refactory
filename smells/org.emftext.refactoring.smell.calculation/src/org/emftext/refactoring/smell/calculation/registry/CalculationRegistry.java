 
package org.emftext.refactoring.smell.calculation.registry;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.emftext.refactoring.smell.calculation.Calculation;
import org.emftext.refactoring.smell.calculation.CalculationFactory;
import org.emftext.refactoring.smell.calculation.CalculationModel;

@SuppressWarnings("restriction")
public class CalculationRegistry {
	
	@PostConstruct
	void initRegistry(IEclipseContext context, IExtensionRegistry registry) {
		CalculationModel calculationModel = initCalculationModel(registry);
		context.set(CalculationModel.class, calculationModel);
	}

	private CalculationModel initCalculationModel(IExtensionRegistry registry) {
		CalculationModel model = CalculationFactory.eINSTANCE.createCalculationModel();
		if(registry != null){
			IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(ICalculationExtensionPoint.ID);
			if(elements != null){
				for (IConfigurationElement element : elements) {
					try {
						Calculation calculation = (Calculation) element.createExecutableExtension(ICalculationExtensionPoint.calculationClass);
						if(calculation != null){
							model.getCalculations().add(calculation);
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