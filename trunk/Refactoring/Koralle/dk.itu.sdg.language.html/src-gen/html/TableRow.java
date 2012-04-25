/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.TableRow#getTableCells <em>Table Cells</em>}</li>
 *   <li>{@link html.TableRow#getTableRows <em>Table Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getTableRow()
 * @model
 * @generated
 */
public interface TableRow extends Tag {
	/**
	 * Returns the value of the '<em><b>Table Cells</b></em>' containment reference list.
	 * The list contents are of type {@link html.TableCell}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Cells</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Cells</em>' containment reference list.
	 * @see html.HtmlPackage#getTableRow_TableCells()
	 * @model containment="true"
	 * @generated
	 */
	EList<TableCell> getTableCells();

	/**
	 * Returns the value of the '<em><b>Table Rows</b></em>' containment reference list.
	 * The list contents are of type {@link html.TableRow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Rows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Rows</em>' containment reference list.
	 * @see html.HtmlPackage#getTableRow_TableRows()
	 * @model containment="true"
	 * @generated
	 */
	EList<TableRow> getTableRows();

} // TableRow
