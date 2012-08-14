/**
 */
package rolemapping;

import ecore.EAttribute;

import org.eclipse.emf.ecore.EObject;

import roles.RoleAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link rolemapping.AttributeMapping#getRoleAttribute <em>Role Attribute</em>}</li>
 *   <li>{@link rolemapping.AttributeMapping#getClassAttribute <em>Class Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see rolemapping.RolemappingPackage#getAttributeMapping()
 * @model
 * @generated
 */
public interface AttributeMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Role Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Attribute</em>' reference.
	 * @see #setRoleAttribute(RoleAttribute)
	 * @see rolemapping.RolemappingPackage#getAttributeMapping_RoleAttribute()
	 * @model required="true"
	 * @generated
	 */
	RoleAttribute getRoleAttribute();

	/**
	 * Sets the value of the '{@link rolemapping.AttributeMapping#getRoleAttribute <em>Role Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Attribute</em>' reference.
	 * @see #getRoleAttribute()
	 * @generated
	 */
	void setRoleAttribute(RoleAttribute value);

	/**
	 * Returns the value of the '<em><b>Class Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Attribute</em>' reference.
	 * @see #setClassAttribute(EAttribute)
	 * @see rolemapping.RolemappingPackage#getAttributeMapping_ClassAttribute()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getClassAttribute();

	/**
	 * Sets the value of the '{@link rolemapping.AttributeMapping#getClassAttribute <em>Class Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Attribute</em>' reference.
	 * @see #getClassAttribute()
	 * @generated
	 */
	void setClassAttribute(EAttribute value);

} // AttributeMapping