/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.pl0;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.pl0.ProcedureDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.pl0.ProcedureDeclaration#getBlock <em>Block</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.pl0.PL0Package#getProcedureDeclaration()
 * @model
 * @generated
 */
public interface ProcedureDeclaration extends EObject {
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
   * @see org.emftext.language.pl0.PL0Package#getProcedureDeclaration_Name()
   * @model required="true"
   * @generated
   */
	String getName();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.ProcedureDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
	void setName(String value);

	/**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(Block)
   * @see org.emftext.language.pl0.PL0Package#getProcedureDeclaration_Block()
   * @model containment="true" required="true"
   * @generated
   */
	Block getBlock();

	/**
   * Sets the value of the '{@link org.emftext.language.pl0.ProcedureDeclaration#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
	void setBlock(Block value);

} // ProcedureDeclaration
