/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.rolemapping;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getOutgoingRelationMappings <em>Outgoing Relation Mappings</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.rolemapping.ConcreteMapping#getAttributeMappings <em>Attribute Mappings</em>}</li>
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

	/**
   * Returns the value of the '<em><b>Outgoing Relation Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.refactoring.rolemapping.RelationMapping}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Relation Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Relation Mappings</em>' containment reference list.
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getConcreteMapping_OutgoingRelationMappings()
   * @model containment="true"
   * @generated
   */
	EList<RelationMapping> getOutgoingRelationMappings();

	/**
   * Returns the value of the '<em><b>Attribute Mappings</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.refactoring.rolemapping.AttributeMapping}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Mappings</em>' containment reference list.
   * @see org.emftext.language.refactoring.rolemapping.RolemappingPackage#getConcreteMapping_AttributeMappings()
   * @model containment="true"
   * @generated
   */
	EList<AttributeMapping> getAttributeMappings();

} // ConcreteMapping
