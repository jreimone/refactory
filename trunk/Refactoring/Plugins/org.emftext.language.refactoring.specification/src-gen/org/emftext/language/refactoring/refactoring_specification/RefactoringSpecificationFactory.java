/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage
 * @generated
 */
public interface RefactoringSpecificationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RefactoringSpecificationFactory eINSTANCE = org.emftext.language.refactoring.refactoring_specification.impl.RefactoringSpecificationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Refactoring Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refactoring Specification</em>'.
	 * @generated
	 */
	RefactoringSpecification createRefactoringSpecification();

	/**
	 * Returns a new object of class '<em>CREATE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CREATE</em>'.
	 * @generated
	 */
	CREATE createCREATE();

	/**
	 * Returns a new object of class '<em>MOVE</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>MOVE</em>'.
	 * @generated
	 */
	MOVE createMOVE();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

	/**
	 * Returns a new object of class '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Reference</em>'.
	 * @generated
	 */
	VariableReference createVariableReference();

	/**
	 * Returns a new object of class '<em>Role Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Reference</em>'.
	 * @generated
	 */
	RoleReference createRoleReference();

	/**
	 * Returns a new object of class '<em>Relation Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Reference</em>'.
	 * @generated
	 */
	RelationReference createRelationReference();

	/**
	 * Returns a new object of class '<em>SET</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SET</em>'.
	 * @generated
	 */
	SET createSET();

	/**
	 * Returns a new object of class '<em>ASSIGN</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ASSIGN</em>'.
	 * @generated
	 */
	ASSIGN createASSIGN();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RefactoringSpecificationPackage getRefactoringSpecificationPackage();

} //RefactoringSpecificationFactory
