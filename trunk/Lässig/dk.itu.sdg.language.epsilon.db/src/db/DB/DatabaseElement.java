/**
 */
package db.DB;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link db.DB.DatabaseElement#getDatabase <em>Database</em>}</li>
 * </ul>
 * </p>
 *
 * @see db.DB.DBPackage#getDatabaseElement()
 * @model abstract="true"
 * @generated
 */
public interface DatabaseElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Database</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link db.DB.Database#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Database</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database</em>' container reference.
	 * @see #setDatabase(Database)
	 * @see db.DB.DBPackage#getDatabaseElement_Database()
	 * @see db.DB.Database#getContents
	 * @model opposite="contents" transient="false"
	 * @generated
	 */
	Database getDatabase();

	/**
	 * Sets the value of the '{@link db.DB.DatabaseElement#getDatabase <em>Database</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database</em>' container reference.
	 * @see #getDatabase()
	 * @generated
	 */
	void setDatabase(Database value);

} // DatabaseElement
