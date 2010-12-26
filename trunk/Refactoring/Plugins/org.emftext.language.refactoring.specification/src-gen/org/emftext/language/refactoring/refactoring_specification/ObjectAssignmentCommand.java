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
 * A representation of the model object '<em><b>Object Assignment Command</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getObjectAssignmentCommand()
 * @model abstract="true"
 * @generated
 */
public interface ObjectAssignmentCommand extends EObject
{
  /**
   * Returns the value of the '<em><b>Declaration</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.refactoring_specification.VariableAssignment#getAssignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declaration</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaration</em>' container reference.
   * @see #setDeclaration(VariableAssignment)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getObjectAssignmentCommand_Declaration()
   * @see org.emftext.language.refactoring.refactoring_specification.VariableAssignment#getAssignment
   * @model opposite="assignment" required="true" transient="false"
   * @generated
   */
  VariableAssignment getDeclaration();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.ObjectAssignmentCommand#getDeclaration <em>Declaration</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declaration</em>' container reference.
   * @see #getDeclaration()
   * @generated
   */
  void setDeclaration(VariableAssignment value);

} // ObjectAssignmentCommand
