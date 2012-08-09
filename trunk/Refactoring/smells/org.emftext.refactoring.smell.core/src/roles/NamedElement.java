/**
 */
package roles;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link roles.NamedElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see roles.RolesPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends Commentable {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see roles.RolesPackage#getNamedElement_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link roles.NamedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // NamedElement
