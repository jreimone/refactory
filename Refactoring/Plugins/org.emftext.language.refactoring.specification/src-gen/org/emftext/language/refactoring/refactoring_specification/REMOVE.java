/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>REMOVE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.REMOVE#getRemoval <em>Removal</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.REMOVE#getModifier <em>Modifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getREMOVE()
 * @model
 * @generated
 */
public interface REMOVE extends DeleteCommand, ContainmentCommand {
	/**
	 * Returns the value of the '<em><b>Removal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Removal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Removal</em>' containment reference.
	 * @see #setRemoval(ObjectRemoval)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getREMOVE_Removal()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ObjectRemoval getRemoval();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.REMOVE#getRemoval <em>Removal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Removal</em>' containment reference.
	 * @see #getRemoval()
	 * @generated
	 */
	void setRemoval(ObjectRemoval value);

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' containment reference.
	 * @see #setModifier(RemoveModifier)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getREMOVE_Modifier()
	 * @model containment="true"
	 * @generated
	 */
	RemoveModifier getModifier();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.REMOVE#getModifier <em>Modifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modifier</em>' containment reference.
	 * @see #getModifier()
	 * @generated
	 */
	void setModifier(RemoveModifier value);

} // REMOVE
