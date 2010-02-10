/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.roles;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.roles.RoleModel#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.roles.RoleModel#getRelations <em>Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.roles.RolesPackage#getRoleModel()
 * @model
 * @generated
 */
public interface RoleModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.roles.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRoleModel_Roles()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.roles.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see org.emftext.language.refactoring.roles.RolesPackage#getRoleModel_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relation> getRelations();

} // RoleModel
