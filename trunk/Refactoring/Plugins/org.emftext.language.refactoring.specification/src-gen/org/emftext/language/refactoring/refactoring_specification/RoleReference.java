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
 * A representation of the model object '<em><b>Role Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RoleReference#getRole <em>Role</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RoleReference#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRoleReference()
 * @model
 * @generated
 */
public interface RoleReference extends ObjectAssignmentCommand
{
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
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRoleReference_Role()
	 * @model required="true"
	 * @generated
	 */
  Role getRole();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.RoleReference#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
  void setRole(Role value);

  /**
	 * Returns the value of the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' containment reference.
	 * @see #setFrom(FromClause)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRoleReference_From()
	 * @model containment="true" required="true"
	 * @generated
	 */
  FromClause getFrom();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.RoleReference#getFrom <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' containment reference.
	 * @see #getFrom()
	 * @generated
	 */
  void setFrom(FromClause value);

} // RoleReference
