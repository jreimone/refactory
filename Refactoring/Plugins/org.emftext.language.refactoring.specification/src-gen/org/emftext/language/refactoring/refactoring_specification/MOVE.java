/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>MOVE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.MOVE#getSource <em>Source</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.MOVE#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getMOVE()
 * @model
 * @generated
 */
public interface MOVE extends ContainmentCommand {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(SourceContext)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getMOVE_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SourceContext getSource();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.MOVE#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(SourceContext value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(TargetContext)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getMOVE_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetContext getTarget();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.MOVE#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(TargetContext value);

} // MOVE
