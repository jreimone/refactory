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
 * A representation of the model object '<em><b>TRACE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.TRACE#getReference <em>Reference</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.TRACE#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getTRACE()
 * @model
 * @generated
 */
public interface TRACE extends ObjectAssignmentCommand
{
  /**
	 * Returns the value of the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' containment reference.
	 * @see #setReference(ObjectReference)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getTRACE_Reference()
	 * @model containment="true" required="true"
	 * @generated
	 */
  ObjectReference getReference();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.TRACE#getReference <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' containment reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(ObjectReference value);

		/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Role</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(Role)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getTRACE_Role()
	 * @model required="true"
	 * @generated
	 */
  Role getRole();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.TRACE#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
  void setRole(Role value);

} // TRACE
