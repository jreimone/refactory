/**
 */
package org.emftext.language.refactoring.refactoringcomposition;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.roles.Role;
import org.emftext.language.refactoring.roles.RoleModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Target Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSource <em>Source</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTarget <em>Target</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSourceRoleModel <em>Source Role Model</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTargetRoleModel <em>Target Role Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getSourceTargetBinding()
 * @model
 * @generated
 */
public interface SourceTargetBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Role)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getSourceTargetBinding_Source()
	 * @model required="true"
	 * @generated
	 */
	Role getSource();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Role value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Role)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getSourceTargetBinding_Target()
	 * @model required="true"
	 * @generated
	 */
	Role getTarget();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Role value);

	/**
	 * Returns the value of the '<em><b>Source Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Role Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Role Model</em>' reference.
	 * @see #setSourceRoleModel(RoleModel)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getSourceTargetBinding_SourceRoleModel()
	 * @model required="true"
	 * @generated
	 */
	RoleModel getSourceRoleModel();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getSourceRoleModel <em>Source Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Role Model</em>' reference.
	 * @see #getSourceRoleModel()
	 * @generated
	 */
	void setSourceRoleModel(RoleModel value);

	/**
	 * Returns the value of the '<em><b>Target Role Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Role Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Role Model</em>' reference.
	 * @see #setTargetRoleModel(RoleModel)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getSourceTargetBinding_TargetRoleModel()
	 * @model required="true"
	 * @generated
	 */
	RoleModel getTargetRoleModel();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding#getTargetRoleModel <em>Target Role Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Role Model</em>' reference.
	 * @see #getTargetRoleModel()
	 * @generated
	 */
	void setTargetRoleModel(RoleModel value);

} // SourceTargetBinding
