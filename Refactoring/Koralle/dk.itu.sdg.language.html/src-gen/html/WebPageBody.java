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
 * A representation of the model object '<em><b>Web Page Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.WebPageBody#getHead <em>Head</em>}</li>
 *   <li>{@link html.WebPageBody#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getWebPageBody()
 * @model
 * @generated
 */
public interface WebPageBody extends EObject {
	/**
	 * Returns the value of the '<em><b>Head</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head</em>' containment reference.
	 * @see #setHead(Head)
	 * @see html.HtmlPackage#getWebPageBody_Head()
	 * @model containment="true"
	 * @generated
	 */
	Head getHead();

	/**
	 * Sets the value of the '{@link html.WebPageBody#getHead <em>Head</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head</em>' containment reference.
	 * @see #getHead()
	 * @generated
	 */
	void setHead(Head value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference list.
	 * The list contents are of type {@link html.Body}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference list.
	 * @see html.HtmlPackage#getWebPageBody_Body()
	 * @model containment="true"
	 * @generated
	 */
	EList<Body> getBody();

} // WebPageBody
