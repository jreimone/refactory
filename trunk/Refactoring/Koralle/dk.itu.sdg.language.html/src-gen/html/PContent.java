/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PContent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.PContent#getTag <em>Tag</em>}</li>
 *   <li>{@link html.PContent#getWord <em>Word</em>}</li>
 *   <li>{@link html.PContent#getPContent <em>PContent</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getPContent()
 * @model
 * @generated
 */
public interface PContent extends EObject {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' containment reference.
	 * @see #setTag(Tag)
	 * @see html.HtmlPackage#getPContent_Tag()
	 * @model containment="true"
	 * @generated
	 */
	Tag getTag();

	/**
	 * Sets the value of the '{@link html.PContent#getTag <em>Tag</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' containment reference.
	 * @see #getTag()
	 * @generated
	 */
	void setTag(Tag value);

	/**
	 * Returns the value of the '<em><b>Word</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word</em>' containment reference.
	 * @see #setWord(Word)
	 * @see html.HtmlPackage#getPContent_Word()
	 * @model containment="true"
	 * @generated
	 */
	Word getWord();

	/**
	 * Sets the value of the '{@link html.PContent#getWord <em>Word</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Word</em>' containment reference.
	 * @see #getWord()
	 * @generated
	 */
	void setWord(Word value);

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
	 * @see html.HtmlPackage#getPContent_PContent()
	 * @model containment="true"
	 * @generated
	 */
	PContent getPContent();

	/**
	 * Sets the value of the '{@link html.PContent#getPContent <em>PContent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>PContent</em>' containment reference.
	 * @see #getPContent()
	 * @generated
	 */
	void setPContent(PContent value);

} // PContent
