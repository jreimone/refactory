/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CREATE</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getVarDeclaration <em>Var Declaration</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRoleReference <em>Source Role Reference</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getTargetContext <em>Target Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCREATE()
 * @model
 * @generated
 */
public interface CREATE extends PrimitiveCommand {
	/**
	 * Returns the value of the '<em><b>Var Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Declaration</em>' containment reference.
	 * @see #setVarDeclaration(Variable)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCREATE_VarDeclaration()
	 * @model containment="true"
	 * @generated
	 */
	Variable getVarDeclaration();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getVarDeclaration <em>Var Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Declaration</em>' containment reference.
	 * @see #getVarDeclaration()
	 * @generated
	 */
	void setVarDeclaration(Variable value);

	/**
	 * Returns the value of the '<em><b>Source Role Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Role Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Role Reference</em>' containment reference.
	 * @see #setSourceRoleReference(RoleReference)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCREATE_SourceRoleReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RoleReference getSourceRoleReference();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getSourceRoleReference <em>Source Role Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role Reference</em>' containment reference.
	 * @see #getSourceRoleReference()
	 * @generated
	 */
	void setSourceRoleReference(RoleReference value);

	/**
	 * Returns the value of the '<em><b>Target Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Context</em>' containment reference.
	 * @see #setTargetContext(TargetContext)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getCREATE_TargetContext()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TargetContext getTargetContext();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.CREATE#getTargetContext <em>Target Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Context</em>' containment reference.
	 * @see #getTargetContext()
	 * @generated
	 */
	void setTargetContext(TargetContext value);

} // CREATE
