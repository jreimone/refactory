/**
 */
package db.DB;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link db.DB.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link db.DB.Table#getPrimaryKeys <em>Primary Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see db.DB.DBPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends DatabaseElement {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link db.DB.Column}.
	 * It is bidirectional and its opposite is '{@link db.DB.Column#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see db.DB.DBPackage#getTable_Columns()
	 * @see db.DB.Column#getTable
	 * @model opposite="table" containment="true"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Primary Keys</b></em>' reference list.
	 * The list contents are of type {@link db.DB.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Keys</em>' reference list.
	 * @see db.DB.DBPackage#getTable_PrimaryKeys()
	 * @model
	 * @generated
	 */
	EList<Column> getPrimaryKeys();

} // Table
