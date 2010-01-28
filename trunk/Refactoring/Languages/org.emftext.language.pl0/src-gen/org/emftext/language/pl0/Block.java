/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.Block#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.emftext.language.pl0.Block#getConstants <em>Constants</em>}</li>
 *   <li>{@link org.emftext.language.pl0.Block#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link org.emftext.language.pl0.Block#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getBlock()
 * @model
 * @generated
 */
public interface Block extends EObject {
	/**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.pl0.VarDeclaration}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.emftext.language.pl0.PL0Package#getBlock_Variables()
   * @model containment="true"
   * @generated
   */
	EList<VarDeclaration> getVariables();

	/**
   * Returns the value of the '<em><b>Constants</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.pl0.ConstDeclaration}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Constants</em>' containment reference list.
   * @see org.emftext.language.pl0.PL0Package#getBlock_Constants()
   * @model containment="true"
   * @generated
   */
	EList<ConstDeclaration> getConstants();

	/**
   * Returns the value of the '<em><b>Procedures</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.pl0.ProcedureDeclaration}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Procedures</em>' containment reference list.
   * @see org.emftext.language.pl0.PL0Package#getBlock_Procedures()
   * @model containment="true"
   * @generated
   */
	EList<ProcedureDeclaration> getProcedures();

	/**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Body)
   * @see org.emftext.language.pl0.PL0Package#getBlock_Body()
   * @model containment="true" required="true"
   * @generated
   */
	Body getBody();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.Block#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
	void setBody(Body value);

} // Block
