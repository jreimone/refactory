/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef#getReferredParam <em>Referred Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getParameterRef()
 * @model
 * @generated
 */
public interface ParameterRef extends Variable
{
  /**
   * Returns the value of the '<em><b>Referred Param</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referred Param</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referred Param</em>' reference.
   * @see #setReferredParam(Variable)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getParameterRef_ReferredParam()
   * @model transient="true"
   * @generated
   */
  Variable getReferredParam();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef#getReferredParam <em>Referred Param</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referred Param</em>' reference.
   * @see #getReferredParam()
   * @generated
   */
  void setReferredParam(Variable value);

} // ParameterRef
