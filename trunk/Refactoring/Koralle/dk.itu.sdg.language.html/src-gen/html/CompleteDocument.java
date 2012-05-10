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
 * A representation of the model object '<em><b>Complete Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link html.CompleteDocument#getDoctype <em>Doctype</em>}</li>
 *   <li>{@link html.CompleteDocument#getParameters <em>Parameters</em>}</li>
 *   <li>{@link html.CompleteDocument#getWebPageBody <em>Web Page Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see html.HtmlPackage#getCompleteDocument()
 * @model
 * @generated
 */
public interface CompleteDocument extends Document {
	/**
	 * Returns the value of the '<em><b>Doctype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Doctype</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Doctype</em>' containment reference.
	 * @see #setDoctype(DocType)
	 * @see html.HtmlPackage#getCompleteDocument_Doctype()
	 * @model containment="true"
	 * @generated
	 */
	DocType getDoctype();

	/**
	 * Sets the value of the '{@link html.CompleteDocument#getDoctype <em>Doctype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Doctype</em>' containment reference.
	 * @see #getDoctype()
	 * @generated
	 */
	void setDoctype(DocType value);

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
	 * @see html.HtmlPackage#getCompleteDocument_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Web Page Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Web Page Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Web Page Body</em>' containment reference.
	 * @see #setWebPageBody(WebPageBody)
	 * @see html.HtmlPackage#getCompleteDocument_WebPageBody()
	 * @model containment="true"
	 * @generated
	 */
	WebPageBody getWebPageBody();

	/**
	 * Sets the value of the '{@link html.CompleteDocument#getWebPageBody <em>Web Page Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Web Page Body</em>' containment reference.
	 * @see #getWebPageBody()
	 * @generated
	 */
	void setWebPageBody(WebPageBody value);

} // CompleteDocument
