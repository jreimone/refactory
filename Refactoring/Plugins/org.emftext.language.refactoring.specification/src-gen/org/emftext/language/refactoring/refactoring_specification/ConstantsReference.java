/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.refactoring.refactoring_specification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constants Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.refactoring.refactoring_specification.ConstantsReference#getReferencedConstant <em>Referenced Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getConstantsReference()
 * @model
 * @generated
 */
public interface ConstantsReference extends ObjectReference, SourceContext
{
  /**
   * Returns the value of the '<em><b>Referenced Constant</b></em>' attribute.
   * The literals are from the enumeration {@link org.emftext.language.refactoring.refactoring_specification.Constants}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced Constant</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Constant</em>' attribute.
   * @see org.emftext.language.refactoring.refactoring_specification.Constants
   * @see #setReferencedConstant(Constants)
   * @see org.emftext.language.refactoring.refactoring_specification.RefactoringSpecificationPackage#getConstantsReference_ReferencedConstant()
   * @model required="true"
   * @generated
   */
  Constants getReferencedConstant();

  /**
   * Sets the value of the '{@link org.emftext.language.refactoring.refactoring_specification.ConstantsReference#getReferencedConstant <em>Referenced Constant</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Constant</em>' attribute.
   * @see org.emftext.language.refactoring.refactoring_specification.Constants
   * @see #getReferencedConstant()
   * @generated
   */
  void setReferencedConstant(Constants value);

} // ConstantsReference
