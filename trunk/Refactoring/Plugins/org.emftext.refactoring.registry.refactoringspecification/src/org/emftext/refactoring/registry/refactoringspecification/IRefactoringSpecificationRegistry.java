package org.emftext.refactoring.registry.refactoringspecification;

import java.util.Collection;

import org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification;
import org.emftext.language.refactoring.roles.RoleModel;
import org.emftext.refactoring.registry.refactoringspecification.exceptions.RefSpecAlreadyRegisteredException;
import org.emftext.refactoring.registry.refactoringspecification.impl.BasicRefactoringSpecificationRegistry;

public interface IRefactoringSpecificationRegistry {

	public static final IRefactoringSpecificationRegistry INSTANCE = new BasicRefactoringSpecificationRegistry();
	
	/**
	 * Returns the {@link RefactoringSpecification refspec} for the given {@link RoleModel}
	 * @param roleModel
	 * @return
	 */
	public RefactoringSpecification getRefSpec(RoleModel roleModel);
	
	/**
	 * Returns all registered {@link RefactoringSpecification refspecs}.
	 * @return
	 */
	public Collection<RefactoringSpecification> getAllRefSpecs();
	
	/**
	 * Invoke this method if you want to register a new {@link RefactoringSpecification refspec} at runtime.
	 * @param refSpec
	 */
	public void registerRefSpec(RefactoringSpecification refSpec) throws RefSpecAlreadyRegisteredException;
	
	/**
	 * Use this method to update an already registered refspec
	 * @param refSpec
	 */
	public void updateRefSpec(RefactoringSpecification refSpec);
	
}
