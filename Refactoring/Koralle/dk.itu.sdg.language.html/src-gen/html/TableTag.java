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
 * A representation of the model object '<em><b>Table Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.TableTag#getTableRows <em>Table Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getTableTag()
 * @model
 * @generated
 */
public interface TableTag extends Tag {
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
	 * @see html.HtmlPackage#getTableTag_TableRows()
	 * @model containment="true"
	 * @generated
	 */
	EList<TableRow> getTableRows();

} // TableTag
