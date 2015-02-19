/**
 */
package org.emftext.language.refactoring.refactoringcomposition;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Role Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getNextMapping <em>Next Mapping</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getPreviousMapping <em>Previous Mapping</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getRoleMapping <em>Role Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getBoundRoleMapping()
 * @model
 * @generated
 */
public interface BoundRoleMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Next Mapping</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getPreviousMapping <em>Previous Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Mapping</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Mapping</em>' containment reference.
	 * @see #setNextMapping(BoundRoleMapping)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getBoundRoleMapping_NextMapping()
	 * @see org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getPreviousMapping
	 * @model opposite="previousMapping" containment="true"
	 * @generated
	 */
	BoundRoleMapping getNextMapping();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getNextMapping <em>Next Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Mapping</em>' containment reference.
	 * @see #getNextMapping()
	 * @generated
	 */
	void setNextMapping(BoundRoleMapping value);

	/**
	 * Returns the value of the '<em><b>Previous Mapping</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getNextMapping <em>Next Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Mapping</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Mapping</em>' container reference.
	 * @see #setPreviousMapping(BoundRoleMapping)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getBoundRoleMapping_PreviousMapping()
	 * @see org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getNextMapping
	 * @model opposite="nextMapping" transient="false"
	 * @generated
	 */
	BoundRoleMapping getPreviousMapping();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getPreviousMapping <em>Previous Mapping</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Mapping</em>' container reference.
	 * @see #getPreviousMapping()
	 * @generated
	 */
	void setPreviousMapping(BoundRoleMapping value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.refactoringcomposition.SourceTargetBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getBoundRoleMapping_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<SourceTargetBinding> getBindings();

	/**
	 * Returns the value of the '<em><b>Role Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Mapping</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Mapping</em>' reference.
	 * @see #setRoleMapping(RoleMapping)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getBoundRoleMapping_RoleMapping()
	 * @model required="true"
	 * @generated
	 */
	RoleMapping getRoleMapping();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping#getRoleMapping <em>Role Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Mapping</em>' reference.
	 * @see #getRoleMapping()
	 * @generated
	 */
	void setRoleMapping(RoleMapping value);

} // BoundRoleMapping
