/**
 */
package db.DB;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link db.DB.Database#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see db.DB.DBPackage#getDatabase()
 * @model
 * @generated
 */
public interface Database extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link db.DB.DatabaseElement}.
	 * It is bidirectional and its opposite is '{@link db.DB.DatabaseElement#getDatabase <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see db.DB.DBPackage#getDatabase_Contents()
	 * @see db.DB.DatabaseElement#getDatabase
	 * @model opposite="database" containment="true"
	 * @generated
	 */
	EList<DatabaseElement> getContents();

} // Database
