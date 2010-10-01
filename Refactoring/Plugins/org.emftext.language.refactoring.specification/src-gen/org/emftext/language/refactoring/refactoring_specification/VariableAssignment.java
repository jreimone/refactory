/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.VariableAssignment#getAssignment <em>Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends Instruction, VariableDeclarationCommand
{
  /**
   * Returns the value of the '<em><b>Assignment</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand#getDeclaration <em>Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assignment</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assignment</em>' containment reference.
   * @see #setAssignment(ObjectAssignmentCommand)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getVariableAssignment_Assignment()
   * @see org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand#getDeclaration
   * @model opposite="declaration" containment="true" required="true"
   * @generated
   */
  ObjectAssignmentCommand getAssignment();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.VariableAssignment#getAssignment <em>Assignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assignment</em>' containment reference.
   * @see #getAssignment()
   * @generated
   */
  void setAssignment(ObjectAssignmentCommand value);

} // VariableAssignment
