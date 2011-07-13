/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.emftext.language.refactoring.roles.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CREATE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRole <em>Source Role</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getTargetContext <em>Target Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCREATE()
 * @model
 * @generated
 */
public interface CREATE extends ContainmentCommand, VariableDeclarationCommand
{
  /**
	 * Returns the value of the '<em><b>Source Role</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Role</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Role</em>' reference.
	 * @see #setSourceRole(Role)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCREATE_SourceRole()
	 * @model required="true"
	 * @generated
	 */
  Role getSourceRole();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRole <em>Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role</em>' reference.
	 * @see #getSourceRole()
	 * @generated
	 */
  void setSourceRole(Role value);

  /**
	 * Returns the value of the '<em><b>Target Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Context</em>' containment reference.
	 * @see #setTargetContext(TargetContext)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCREATE_TargetContext()
	 * @model containment="true"
	 * @generated
	 */
  TargetContext getTargetContext();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getTargetContext <em>Target Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Context</em>' containment reference.
	 * @see #getTargetContext()
	 * @generated
	 */
  void setTargetContext(TargetContext value);

} // CREATE
