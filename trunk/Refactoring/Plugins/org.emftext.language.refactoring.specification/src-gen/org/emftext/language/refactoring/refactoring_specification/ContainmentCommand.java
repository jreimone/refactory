/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.ContainmentCommand#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getContainmentCommand()
 * @model abstract="true"
 * @generated
 */
public interface ContainmentCommand extends Instruction, ReferenceCommand
{
  /**
   * Returns the value of the '<em><b>Index</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' reference.
   * @see #setIndex(IndexVariable)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getContainmentCommand_Index()
   * @model
   * @generated
   */
  IndexVariable getIndex();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.ContainmentCommand#getIndex <em>Index</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' reference.
   * @see #getIndex()
   * @generated
   */
  void setIndex(IndexVariable value);

} // ContainmentCommand
