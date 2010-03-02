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
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.roles.Role > roles = new org.eclipse.emf.common.util.BasicEList < org.emftext.language.refactoring.roles.Role > ( ) ; \r\norg.eclipse.emf.common.util.EList < org.emftext.language.refactoring.rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; \r\nfor ( org.emftext.language.refactoring.rolemapping.ConcreteMapping concreteMapping : mappings ) { \r\n\troles .add ( concreteMapping .getRole ( ) ) ; \r\n} \r\nreturn roles ; \r\n'"
	 * @generated
	 */
	EList<Role> getAllMappedRoles();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.language.refactoring.roles.Role > mappedRoles = new org.eclipse.emf.common.util.BasicEList < org.emftext.language.refactoring.roles.Role > ( ) ; \r\norg.eclipse.emf.ecore.EClass metaclass = object .eClass ( ) ; \r\norg.eclipse.emf.common.util.EList < org.emftext.language.refactoring.rolemapping.ConcreteMapping > mappings = getRoleToMetaelement ( ) ; \r\nfor ( org.emftext.language.refactoring.rolemapping.ConcreteMapping concreteMapping : mappings ) { \r\n\torg.emftext.language.refactoring.roles.Role mappedRole = concreteMapping .getRole ( ) ; \r\n\torg.eclipse.emf.ecore.EClass mappedClass = concreteMapping .getMetaclass ( ) ; \r\n\tif ( mappedClass .equals ( metaclass ) ) { \r\n\t\tmappedRoles .add ( mappedRole ) ; \r\n\t} else if ( mappedRole .getModifier ( ) .contains ( org.emftext.language.refactoring.roles.RoleModifier .SUPER ) ) { \r\n\t\tif ( mappedClass .isSuperTypeOf ( metaclass ) ) { \r\n\t\t\tmappedRoles .add ( mappedRole ) ; \r\n\t\t} \r\n\t} \r\n} \r\nreturn mappedRoles ; \r\n'"
	 * @generated
	 */
	EList<Role> getMappedRolesForEObject(EObject object);

} // Mapping
