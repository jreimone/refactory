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
 * A representation of the model object '<em><b>Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.Head#getParameters <em>Parameters</em>}</li>
 *   <li>{@link html.Head#getHeadItems <em>Head Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getHead()
 * @model
 * @generated
 */
public interface Head extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link html.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see html.HtmlPackage#getHead_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Head Items</b></em>' containment reference list.
	 * The list contents are of type {@link html.HeadItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Items</em>' containment reference list.
	 * @see html.HtmlPackage#getHead_HeadItems()
	 * @model containment="true"
	 * @generated
	 */
	EList<HeadItem> getHeadItems();

} // Head
