/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.emftext.language.refactoring.roles.RoleAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASSIGN</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN#getTargetAttribute <em>Target Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getASSIGN()
 * @model
 * @generated
 */
public interface ASSIGN extends AttributeCommand {
	/**
	 * Returns the value of the '<em><b>Source Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Attribute</em>' reference.
	 * @see #setSourceAttribute(RoleAttribute)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getASSIGN_SourceAttribute()
	 * @model
	 * @generated
	 */
	RoleAttribute getSourceAttribute();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN#getSourceAttribute <em>Source Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Attribute</em>' reference.
	 * @see #getSourceAttribute()
	 * @generated
	 */
	void setSourceAttribute(RoleAttribute value);

	/**
	 * Returns the value of the '<em><b>Target Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attribute</em>' reference.
	 * @see #setTargetAttribute(RoleAttribute)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getASSIGN_TargetAttribute()
	 * @model required="true"
	 * @generated
	 */
	RoleAttribute getTargetAttribute();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.ASSIGN#getTargetAttribute <em>Target Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' reference.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(RoleAttribute value);

} // ASSIGN
