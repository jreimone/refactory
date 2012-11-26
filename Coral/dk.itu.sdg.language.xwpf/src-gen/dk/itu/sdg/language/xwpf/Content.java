/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.itu.sdg.language.xwpf;

import org.devboost.stanford.language.NLPParagraph;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link dk.itu.sdg.language.xwpf.Content#getText <em>Text</em>}</li>
 *   <li>{@link dk.itu.sdg.language.xwpf.Content#getNlpContent <em>Nlp Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getContent()
 * @model annotation="import language='platform:/resource/org.devboost.stanford.language/metamodel/language.ecore'"
 * @generated
 */
public interface Content extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getContent_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Content#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Nlp Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nlp Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nlp Content</em>' containment reference.
	 * @see #setNlpContent(NLPParagraph)
	 * @see dk.itu.sdg.language.xwpf.XwpfPackage#getContent_NlpContent()
	 * @model containment="true"
	 * @generated
	 */
	NLPParagraph getNlpContent();

	/**
	 * Sets the value of the '{@link dk.itu.sdg.language.xwpf.Content#getNlpContent <em>Nlp Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nlp Content</em>' containment reference.
	 * @see #getNlpContent()
	 * @generated
	 */
	void setNlpContent(NLPParagraph value);

} // Content
