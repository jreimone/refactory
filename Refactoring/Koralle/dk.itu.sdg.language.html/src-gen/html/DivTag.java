/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Div Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.DivTag#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getDivTag()
 * @model
 * @generated
 */
public interface DivTag extends Tag {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference.
	 * @see #setContent(Content)
	 * @see html.HtmlPackage#getDivTag_Content()
	 * @model containment="true"
	 * @generated
	 */
	Content getContent();

	/**
	 * Sets the value of the '{@link html.DivTag#getContent <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' containment reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(Content value);

} // DivTag
