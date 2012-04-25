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
 * A representation of the model object '<em><b>UI Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.UITag#getListItems <em>List Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getUITag()
 * @model
 * @generated
 */
public interface UITag extends Tag {
	/**
	 * Returns the value of the '<em><b>List Items</b></em>' containment reference list.
	 * The list contents are of type {@link html.ListItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Items</em>' containment reference list.
	 * @see html.HtmlPackage#getUITag_ListItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<ListItem> getListItems();

} // UITag
