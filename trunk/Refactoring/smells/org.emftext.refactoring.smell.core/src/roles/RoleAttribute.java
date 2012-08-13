/**
 */
package roles;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link roles.RoleAttribute#getModifier <em>Modifier</em>}</li>
 *   <li>{@link roles.RoleAttribute#getAttributeRole <em>Attribute Role</em>}</li>
 *   <li>{@link roles.RoleAttribute#getInterpretationContext <em>Interpretation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see roles.RolesPackage#getRoleAttribute()
 * @model
 * @generated
 */
public interface RoleAttribute extends NamedElement, RoleFeature {
	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' attribute list.
	 * The list contents are of type {@link roles.RoleModifier}.
	 * The literals are from the enumeration {@link roles.RoleModifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' attribute list.
	 * @see roles.RoleModifier
	 * @see roles.RolesPackage#getRoleAttribute_Modifier()
	 * @model unique="false"
	 * @generated
	 */
	EList<RoleModifier> getModifier();

	/**
	 * Returns the value of the '<em><b>Attribute Role</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link roles.Role#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Role</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Role</em>' container reference.
	 * @see #setAttributeRole(Role)
	 * @see roles.RolesPackage#getRoleAttribute_AttributeRole()
	 * @see roles.Role#getAttributes
	 * @model opposite="attributes" required="true" transient="false"
	 * @generated
	 */
	Role getAttributeRole();

	/**
	 * Sets the value of the '{@link roles.RoleAttribute#getAttributeRole <em>Attribute Role</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Role</em>' container reference.
	 * @see #getAttributeRole()
	 * @generated
	 */
	void setAttributeRole(Role value);

	/**
	 * Returns the value of the '<em><b>Interpretation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpretation Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpretation Context</em>' reference.
	 * @see #setInterpretationContext(EObject)
	 * @see roles.RolesPackage#getRoleAttribute_InterpretationContext()
	 * @model
	 * @generated
	 */
	EObject getInterpretationContext();

	/**
	 * Sets the value of the '{@link roles.RoleAttribute#getInterpretationContext <em>Interpretation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpretation Context</em>' reference.
	 * @see #getInterpretationContext()
	 * @generated
	 */
	void setInterpretationContext(EObject value);

} // RoleAttribute
