/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refactoring Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getUsedRoleModel <em>Used Role Model</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getInstructions <em>Instructions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRefactoringSpecification()
 * @model
 * @generated
 */
public interface RefactoringSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Used Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Role Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Role Model</em>' reference.
	 * @see #setUsedRoleModel(RoleModel)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRefactoringSpecification_UsedRoleModel()
	 * @model required="true"
	 * @generated
	 */
	RoleModel getUsedRoleModel();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getUsedRoleModel <em>Used Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Role Model</em>' reference.
	 * @see #getUsedRoleModel()
	 * @generated
	 */
	void setUsedRoleModel(RoleModel value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRefactoringSpecification_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.RefactoringSpecification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Instructions</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.refactoring_specification.Instruction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instructions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instructions</em>' containment reference list.
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRefactoringSpecification_Instructions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Instruction> getInstructions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Variable> getDeclaredVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Variable getVariableByName(String name);

} // RefactoringSpecification
