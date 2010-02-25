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
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRoleReference()
 * @model
 * @generated
 */
public interface RoleReference extends SourceContext, TargetContext {
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

} // RoleReference
