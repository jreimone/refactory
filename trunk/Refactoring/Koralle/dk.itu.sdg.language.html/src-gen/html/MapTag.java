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
 * A representation of the model object '<em><b>Map Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.MapTag#getMapItems <em>Map Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getMapTag()
 * @model
 * @generated
 */
public interface MapTag extends Tag {
	/**
	 * Returns the value of the '<em><b>Map Items</b></em>' containment reference list.
	 * The list contents are of type {@link html.MapItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map Items</em>' containment reference list.
	 * @see html.HtmlPackage#getMapTag_MapItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<MapItem> getMapItems();

} // MapTag
