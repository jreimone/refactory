/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getVariableDeclarationCommand()
 * @model abstract="true"
 * @generated
 */
public interface VariableDeclarationCommand extends Instruction
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.refactoring_specification.Variable#getContainerCommand <em>Container Command</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(Variable)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getVariableDeclarationCommand_Variable()
   * @see org.emftext.language.refactoring.refactoring_specification.Variable#getContainerCommand
   * @model opposite="containerCommand" containment="true" required="true"
   * @generated
   */
  Variable getVariable();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.VariableDeclarationCommand#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(Variable value);

} // VariableDeclarationCommand
