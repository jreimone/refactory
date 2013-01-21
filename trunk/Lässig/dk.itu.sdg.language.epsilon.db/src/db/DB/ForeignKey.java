/**
 */
package db.DB;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link db.DB.ForeignKey#getParent <em>Parent</em>}</li>
 *   <li>{@link db.DB.ForeignKey#getChild <em>Child</em>}</li>
 *   <li>{@link db.DB.ForeignKey#getIsMany <em>Is Many</em>}</li>
 * </ul>
 * </p>
 *
 * @see db.DB.DBPackage#getForeignKey()
 * @model
 * @generated
 */
public interface ForeignKey extends DatabaseElement {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Column)
	 * @see db.DB.DBPackage#getForeignKey_Parent()
	 * @model
	 * @generated
	 */
	Column getParent();

	/**
	 * Sets the value of the '{@link db.DB.ForeignKey#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Column value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' reference.
	 * @see #setChild(Column)
	 * @see db.DB.DBPackage#getForeignKey_Child()
	 * @model
	 * @generated
	 */
	Column getChild();

	/**
	 * Sets the value of the '{@link db.DB.ForeignKey#getChild <em>Child</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(Column value);

	/**
	 * Returns the value of the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Many</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Many</em>' attribute.
	 * @see #setIsMany(Boolean)
	 * @see db.DB.DBPackage#getForeignKey_IsMany()
	 * @model
	 * @generated
	 */
	Boolean getIsMany();

	/**
	 * Sets the value of the '{@link db.DB.ForeignKey#getIsMany <em>Is Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Many</em>' attribute.
	 * @see #getIsMany()
	 * @generated
	 */
	void setIsMany(Boolean value);

} // ForeignKey
