/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.MapItem#getArea <em>Area</em>}</li>
 *   <li>{@link html.MapItem#getMapItems <em>Map Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getMapItem()
 * @model
 * @generated
 */
public interface MapItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Area</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' containment reference.
	 * @see #setArea(Area)
	 * @see html.HtmlPackage#getMapItem_Area()
	 * @model containment="true"
	 * @generated
	 */
	Area getArea();

	/**
	 * Sets the value of the '{@link html.MapItem#getArea <em>Area</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' containment reference.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(Area value);

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
	 * @see html.HtmlPackage#getMapItem_MapItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<MapItem> getMapItems();

} // MapItem
