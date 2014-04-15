/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Composition Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#isNegative <em>Negative</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#getCall <em>Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternCompositionConstraint()
 * @model
 * @generated
 */
public interface PatternCompositionConstraint extends Constraint
{
  /**
	 * Returns the value of the '<em><b>Negative</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Negative</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Negative</em>' attribute.
	 * @see #setNegative(boolean)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternCompositionConstraint_Negative()
	 * @model
	 * @generated
	 */
  boolean isNegative();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#isNegative <em>Negative</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negative</em>' attribute.
	 * @see #isNegative()
	 * @generated
	 */
  void setNegative(boolean value);

  /**
	 * Returns the value of the '<em><b>Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Call</em>' containment reference.
	 * @see #setCall(PatternCall)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternCompositionConstraint_Call()
	 * @model containment="true"
	 * @generated
	 */
  PatternCall getCall();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint#getCall <em>Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call</em>' containment reference.
	 * @see #getCall()
	 * @generated
	 */
  void setCall(PatternCall value);

} // PatternCompositionConstraint
