/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.emftext.language.refactoring.roles.Relation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RelationReference#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.RelationReference#getRelationRole <em>Relation Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRelationReference()
 * @model
 * @generated
 */
public interface RelationReference extends SourceContext {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' reference.
	 * @see #setRelation(Relation)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRelationReference_Relation()
	 * @model required="true"
	 * @generated
	 */
	Relation getRelation();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.RelationReference#getRelation <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Relation Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Role</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Role</em>' containment reference.
	 * @see #setRelationRole(RoleReference)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getRelationReference_RelationRole()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RoleReference getRelationRole();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.RelationReference#getRelationRole <em>Relation Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Role</em>' containment reference.
	 * @see #getRelationRole()
	 * @generated
	 */
	void setRelationRole(RoleReference value);

} // RelationReference
