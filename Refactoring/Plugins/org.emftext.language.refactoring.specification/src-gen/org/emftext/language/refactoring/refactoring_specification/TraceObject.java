/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.refactoring.roles.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.TraceObject#getContainer <em>Container</em>}</li>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.TraceObject#getAppliedRole <em>Applied Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getTraceObject()
 * @model
 * @generated
 */
public interface TraceObject extends EObject
{
  /**
   * Returns the value of the '<em><b>Container</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Container</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Container</em>' reference.
   * @see #setContainer(EObject)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getTraceObject_Container()
   * @model required="true"
   * @generated
   */
  EObject getContainer();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.TraceObject#getContainer <em>Container</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Container</em>' reference.
   * @see #getContainer()
   * @generated
   */
  void setContainer(EObject value);

  /**
   * Returns the value of the '<em><b>Applied Role</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applied Role</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applied Role</em>' reference.
   * @see #setAppliedRole(Role)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getTraceObject_AppliedRole()
   * @model required="true"
   * @generated
   */
  Role getAppliedRole();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.TraceObject#getAppliedRole <em>Applied Role</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Applied Role</em>' reference.
   * @see #getAppliedRole()
   * @generated
   */
  void setAppliedRole(Role value);

} // TraceObject
