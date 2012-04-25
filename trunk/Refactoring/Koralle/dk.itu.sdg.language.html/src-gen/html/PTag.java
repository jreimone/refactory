/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PTag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.PTag#getPContent <em>PContent</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getPTag()
 * @model
 * @generated
 */
public interface PTag extends Tag {
	/**
	 * Returns the value of the '<em><b>PContent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>PContent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>PContent</em>' containment reference.
	 * @see #setPContent(PContent)
	 * @see html.HtmlPackage#getPTag_PContent()
	 * @model containment="true"
	 * @generated
	 */
	PContent getPContent();

	/**
	 * Sets the value of the '{@link html.PTag#getPContent <em>PContent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PContent</em>' containment reference.
	 * @see #getPContent()
	 * @generated
	 */
	void setPContent(PContent value);

} // PTag
