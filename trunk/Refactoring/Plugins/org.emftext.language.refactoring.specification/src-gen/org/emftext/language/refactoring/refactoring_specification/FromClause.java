/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>From Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.FromClause#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.FromClause#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getFromClause()
 * @model
 * @generated
 */
public interface FromClause extends EObject
{
  /**
	 * Returns the value of the '<em><b>Operator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' containment reference.
	 * @see #setOperator(FromOperator)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getFromClause_Operator()
	 * @model containment="true" required="true"
	 * @generated
	 */
  FromOperator getOperator();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.FromClause#getOperator <em>Operator</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' containment reference.
	 * @see #getOperator()
	 * @generated
	 */
  void setOperator(FromOperator value);

  /**
	 * Returns the value of the '<em><b>Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' containment reference.
	 * @see #setReference(ObjectReference)
	 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getFromClause_Reference()
	 * @model containment="true" required="true"
	 * @generated
	 */
  ObjectReference getReference();

  /**
	 * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.FromClause#getReference <em>Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' containment reference.
	 * @see #getReference()
	 * @generated
	 */
  void setReference(ObjectReference value);

} // FromClause
