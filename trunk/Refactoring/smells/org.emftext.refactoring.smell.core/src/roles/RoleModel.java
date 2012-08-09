/**
 */
package roles;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link roles.RoleModel#getRoles <em>Roles</em>}</li>
 *   <li>{@link roles.RoleModel#getCollaborations <em>Collaborations</em>}</li>
 * </ul>
 * </p>
 *
 * @see roles.RolesPackage#getRoleModel()
 * @model
 * @generated
 */
public interface RoleModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link roles.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see roles.RolesPackage#getRoleModel_Roles()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Collaborations</b></em>' containment reference list.
	 * The list contents are of type {@link roles.Collaboration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collaborations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collaborations</em>' containment reference list.
	 * @see roles.RolesPackage#getRoleModel_Collaborations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Collaboration> getCollaborations();

} // RoleModel
