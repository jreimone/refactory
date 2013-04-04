/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.incquery.patternlanguage.patternLanguage.RelationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType#getRefname <em>Refname</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getReferenceType()
 * @model
 * @generated
 */
public interface ReferenceType extends RelationType
{
  /**
   * Returns the value of the '<em><b>Refname</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Refname</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refname</em>' reference.
   * @see #setRefname(EStructuralFeature)
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getReferenceType_Refname()
   * @model
   * @generated
   */
  EStructuralFeature getRefname();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType#getRefname <em>Refname</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Refname</em>' reference.
   * @see #getRefname()
   * @generated
   */
  void setRefname(EStructuralFeature value);

} // ReferenceType
