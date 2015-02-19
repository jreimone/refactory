/**
 */
package org.emftext.language.refactoring.refactoringcomposition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.emftext.language.refactoring.rolemapping.RoleMapping;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Role Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getTargetMetamodel <em>Target Metamodel</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getFirst <em>First</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getSequence <em>Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getCompositeRoleMapping()
 * @model
 * @generated
 */
public interface CompositeRoleMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getCompositeRoleMapping_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Target Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Metamodel</em>' reference.
	 * @see #setTargetMetamodel(EPackage)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getCompositeRoleMapping_TargetMetamodel()
	 * @model required="true"
	 * @generated
	 */
	EPackage getTargetMetamodel();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getTargetMetamodel <em>Target Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Metamodel</em>' reference.
	 * @see #getTargetMetamodel()
	 * @generated
	 */
	void setTargetMetamodel(EPackage value);

	/**
	 * Returns the value of the '<em><b>First</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' reference.
	 * @see #setFirst(RoleMapping)
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getCompositeRoleMapping_First()
	 * @model required="true"
	 * @generated
	 */
	RoleMapping getFirst();

	/**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoringcomposition.CompositeRoleMapping#getFirst <em>First</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(RoleMapping value);

	/**
	 * Returns the value of the '<em><b>Sequence</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.language.refactoring.refactoringcomposition.BoundRoleMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence</em>' containment reference list.
	 * @see org.emftext.language.refactoring.refactoringcomposition.RefactoringcompositionPackage#getCompositeRoleMapping_Sequence()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<BoundRoleMapping> getSequence();

} // CompositeRoleMapping
