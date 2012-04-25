/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package html;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSL Tag Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.DSLTagStructure#getName <em>Name</em>}</li>
 *   <li>{@link html.DSLTagStructure#getNameClose <em>Name Close</em>}</li>
 *   <li>{@link html.DSLTagStructure#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getDSLTagStructure()
 * @model
 * @generated
 */
public interface DSLTagStructure extends Tag {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see html.HtmlPackage#getDSLTagStructure_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link html.DSLTagStructure#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Name Close</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Close</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Close</em>' attribute.
	 * @see #setNameClose(String)
	 * @see html.HtmlPackage#getDSLTagStructure_NameClose()
	 * @model required="true"
	 * @generated
	 */
	String getNameClose();

	/**
	 * Sets the value of the '{@link html.DSLTagStructure#getNameClose <em>Name Close</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Close</em>' attribute.
	 * @see #getNameClose()
	 * @generated
	 */
	void setNameClose(String value);

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
	 * @see html.HtmlPackage#getDSLTagStructure_Content()
	 * @model containment="true"
	 * @generated
	 */
	Content getContent();

	/**
	 * Sets the value of the '{@link html.DSLTagStructure#getContent <em>Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' containment reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(Content value);

} // DSLTagStructure
