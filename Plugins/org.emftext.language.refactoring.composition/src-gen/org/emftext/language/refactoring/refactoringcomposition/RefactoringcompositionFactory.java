/**
 */
package org.emftext.language.refactoring.refactoringcomposition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage
 * @generated
 */
public interface RefactoringcompositionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RefactoringcompositionFactory eINSTANCE = org.emftext.language.refactoring.refactoringcomposition.impl.RefactoringcompositionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Composite Role Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Role Mapping</em>'.
	 * @generated
	 */
	CompositeRoleMapping createCompositeRoleMapping();

	/**
	 * Returns a new object of class '<em>Bound Role Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Role Mapping</em>'.
	 * @generated
	 */
	BoundRoleMapping createBoundRoleMapping();

	/**
	 * Returns a new object of class '<em>Source Target Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Target Binding</em>'.
	 * @generated
	 */
	SourceTargetBinding createSourceTargetBinding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RefactoringcompositionPackage getRefactoringcompositionPackage();

} //RefactoringcompositionFactory
