/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Reference Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getObjectReferenceAssignment()
 * @model abstract="true"
 * @generated
 */
public interface ObjectReferenceAssignment extends IndexAssignmentCommand
{
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
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getObjectReferenceAssignment_Reference()
   * @model containment="true" required="true"
   * @generated
   */
  ObjectReference getReference();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.ObjectReferenceAssignment#getReference <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' containment reference.
   * @see #getReference()
   * @generated
   */
	void setReference(ObjectReference value);

} // ObjectReferenceAssignment
