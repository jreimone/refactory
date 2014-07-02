package org.emftext.refactoring.initialization;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationExtensionPoint;
import org.emftext.refactoring.registry.refactoringspecification.IRefactoringSpecificationRegistryInitializer;
import org.emftext.refactoring.util.RegistryUtil;

/**
 * Initializes the {@link RefactoringSpecification} registry from the extension point. 
 * 
 */
public class RefactoringSpecificationRegistryInitializer implements IRefactoringSpecificationRegistryInitializer {

	@Override
	public List<RefactoringSpecification> initialize() {
		List<RefactoringSpecification> refSpecs = new LinkedList<RefactoringSpecification>();
		Map<RefactoringSpecification, IConfigurationElement> models = RegistryUtil
				.collectRegisteredResources(
						IRefactoringSpecificationExtensionPoint.ID,
						IRefactoringSpecificationExtensionPoint.RESOURCE_ATTRIBUTE,
						RefactoringSpecification.class);
		for (RefactoringSpecification refSpec : models.keySet()) {
			refSpecs.add(refSpec);
		}
		return refSpecs;
	}

}
