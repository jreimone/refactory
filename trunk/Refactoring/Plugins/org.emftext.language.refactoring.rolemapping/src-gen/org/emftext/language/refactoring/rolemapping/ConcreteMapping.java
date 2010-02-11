/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.roles.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getRole <em>Role</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getMetaclass <em>Metaclass</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getConcreteMapping()
 * @model
 * @generated
 */
public interface ConcreteMapping extends EObject {
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
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getConcreteMapping_Role()
   * @model required="true"
   * @generated
   */
	Role getRole();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getRole <em>Role</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Role</em>' reference.
   * @see #getRole()
   * @generated
   */
	void setRole(Role value);

	/**
   * Returns the value of the '<em><b>Metaclass</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Metaclass</em>' reference.
   * @see #setMetaclass(EClass)
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getConcreteMapping_Metaclass()
   * @model required="true"
   * @generated
   */
	EClass getMetaclass();

	/**
   * Sets the value of the '{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getMetaclass <em>Metaclass</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metaclass</em>' reference.
   * @see #getMetaclass()
   * @generated
   */
	void setMetaclass(EClass value);

} // ConcreteMapping
