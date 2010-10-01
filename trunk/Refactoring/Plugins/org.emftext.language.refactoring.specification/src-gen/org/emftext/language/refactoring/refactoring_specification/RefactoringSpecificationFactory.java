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
public interface RefactoringSpecificationFactory extends EFactory
{
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
   * Returns a new object of class '<em>Collaboration Reference</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Collaboration Reference</em>'.
   * @generated
   */
	CollaborationReference createCollaborationReference();

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
   * Returns a new object of class '<em>From Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>From Clause</em>'.
   * @generated
   */
  FromClause createFromClause();

  /**
   * Returns a new object of class '<em>UPTREE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UPTREE</em>'.
   * @generated
   */
  UPTREE createUPTREE();

  /**
   * Returns a new object of class '<em>Constants Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constants Reference</em>'.
   * @generated
   */
  ConstantsReference createConstantsReference();

  /**
   * Returns a new object of class '<em>Index Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Index Variable</em>'.
   * @generated
   */
  IndexVariable createIndexVariable();

  /**
   * Returns a new object of class '<em>Concrete Index</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concrete Index</em>'.
   * @generated
   */
  ConcreteIndex createConcreteIndex();

  /**
   * Returns a new object of class '<em>FIRST</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FIRST</em>'.
   * @generated
   */
  FIRST createFIRST();

  /**
   * Returns a new object of class '<em>LAST</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>LAST</em>'.
   * @generated
   */
  LAST createLAST();

  /**
   * Returns a new object of class '<em>TRACE</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TRACE</em>'.
   * @generated
   */
  TRACE createTRACE();

  /**
   * Returns a new object of class '<em>Trace Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Object</em>'.
   * @generated
   */
  TraceObject createTraceObject();

  /**
   * Returns a new object of class '<em>Variable Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Assignment</em>'.
   * @generated
   */
  VariableAssignment createVariableAssignment();

  /**
   * Returns a new object of class '<em>PATH</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PATH</em>'.
   * @generated
   */
  PATH createPATH();

  /**
   * Returns a new object of class '<em>FILTER</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>FILTER</em>'.
   * @generated
   */
  FILTER createFILTER();

  /**
   * Returns a new object of class '<em>DISTINCT</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>DISTINCT</em>'.
   * @generated
   */
	DISTINCT createDISTINCT();

		/**
   * Returns a new object of class '<em>UNSET</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>UNSET</em>'.
   * @generated
   */
	UNSET createUNSET();

		/**
   * Returns a new object of class '<em>REMOVE</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>REMOVE</em>'.
   * @generated
   */
	REMOVE createREMOVE();

		/**
   * Returns a new object of class '<em>Role Removal</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Role Removal</em>'.
   * @generated
   */
	RoleRemoval createRoleRemoval();

		/**
   * Returns a new object of class '<em>UNUSED</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>UNUSED</em>'.
   * @generated
   */
	UNUSED createUNUSED();

		/**
   * Returns a new object of class '<em>EMPTY</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>EMPTY</em>'.
   * @generated
   */
	EMPTY createEMPTY();

		/**
   * Returns a new object of class '<em>AFTER</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>AFTER</em>'.
   * @generated
   */
	AFTER createAFTER();

		/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  RefactoringSpecificationPackage getRefactoringSpecificationPackage();

} //RefactoringSpecificationFactory
