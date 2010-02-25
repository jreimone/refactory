/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.Mapping#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.Mapping#getMappedRoleModel <em>Mapped Role Model</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.Mapping#getRoleToMetaelement <em>Role To Metaelement</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
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
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getMapping_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.rolemapping.Mapping#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Mapped Role Model</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped Role Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Mapped Role Model</em>' reference.
   * @see #setMappedRoleModel(RoleModel)
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getMapping_MappedRoleModel()
   * @model required="true"
   * @generated
   */
	RoleModel getMappedRoleModel();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.rolemapping.Mapping#getMappedRoleModel <em>Mapped Role Model</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mapped Role Model</em>' reference.
   * @see #getMappedRoleModel()
   * @generated
   */
	void setMappedRoleModel(RoleModel value);

	/**
   * Returns the value of the '<em><b>Role To Metaelement</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.refactoring.rolemapping.ConcreteMapping}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role To Metaelement</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Role To Metaelement</em>' containment reference list.
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getMapping_RoleToMetaelement()
   * @model containment="true" required="true"
   * @generated
   */
	EList<ConcreteMapping> getRoleToMetaelement();

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @model kind="operation"
   * @generated
   */
	EList<Role> getAllMappedRoles();

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @model
   * @generated
   */
	EList<Role> getMappedRolesForEObject(EObject object);

} // Mapping
