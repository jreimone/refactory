package org.emftext.refactoring.registry.refactoringspecification;

import java.util.List;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;

/**
 * Interface being used from the {@link IRefactoringSpecificationRegistry} to initialize itself.
 * A default implementation is used when running in an Eclipse instance (Platform is running).
 * Provide an own implementation in, e.g., a testing context. 
 *
 * @author jreimann
 *
 */
public interface IRefactoringSpecificationRegistryInitializer {

	/**
	 *  Initializes the registry and returns the initial list of {@link RefactoringSpecification}s.
	 * 
	 * @return
	 */
	public List<RefactoringSpecification> initialize();
}
