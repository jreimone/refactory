/**
 */
package roles;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link roles.Role#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link roles.Role#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link roles.Role#getModifier <em>Modifier</em>}</li>
 *   <li>{@link roles.Role#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see roles.RolesPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link roles.Collaboration}.
	 * It is bidirectional and its opposite is '{@link roles.Collaboration#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see roles.RolesPackage#getRole_Outgoing()
	 * @see roles.Collaboration#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Collaboration> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link roles.Collaboration}.
	 * It is bidirectional and its opposite is '{@link roles.Collaboration#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see roles.RolesPackage#getRole_Incoming()
	 * @see roles.Collaboration#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Collaboration> getIncoming();

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
	 * @see roles.RolesPackage#getRole_Modifier()
	 * @model unique="false"
	 * @generated
	 */
	EList<RoleModifier> getModifier();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link roles.RoleAttribute}.
	 * It is bidirectional and its opposite is '{@link roles.RoleAttribute#getAttributeRole <em>Attribute Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see roles.RolesPackage#getRole_Attributes()
	 * @see roles.RoleAttribute#getAttributeRole
	 * @model opposite="attributeRole" containment="true"
	 * @generated
	 */
	EList<RoleAttribute> getAttributes();

} // Role
