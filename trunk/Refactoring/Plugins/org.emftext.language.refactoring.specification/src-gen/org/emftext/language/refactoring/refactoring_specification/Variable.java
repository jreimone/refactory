/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.Variable#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.Variable#getContainerCommand <em>Container Command</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject
{
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
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getVariable_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.Variable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Container Command</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Container Command</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Container Command</em>' container reference.
   * @see #setContainerCommand(VariableDeclarationCommand)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getVariable_ContainerCommand()
   * @see org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand#getVariable
   * @model opposite="variable" required="true" transient="false"
   * @generated
   */
  VariableDeclarationCommand getContainerCommand();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.Variable#getContainerCommand <em>Container Command</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Container Command</em>' container reference.
   * @see #getContainerCommand()
   * @generated
   */
  void setContainerCommand(VariableDeclarationCommand value);

} // Variable
