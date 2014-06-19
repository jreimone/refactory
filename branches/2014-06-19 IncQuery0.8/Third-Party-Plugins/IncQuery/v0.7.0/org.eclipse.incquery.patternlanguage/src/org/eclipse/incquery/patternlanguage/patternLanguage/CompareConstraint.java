/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compare Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getCompareConstraint()
 * @model
 * @generated
 */
public interface CompareConstraint extends Constraint
{
  /**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(ValueReference)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getCompareConstraint_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
  ValueReference getLeftOperand();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
  void setLeftOperand(ValueReference value);

  /**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature
	 * @see #setFeature(CompareFeature)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getCompareConstraint_Feature()
	 * @model
	 * @generated
	 */
  CompareFeature getFeature();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.CompareFeature
	 * @see #getFeature()
	 * @generated
	 */
  void setFeature(CompareFeature value);

  /**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(ValueReference)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getCompareConstraint_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
  ValueReference getRightOperand();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.CompareConstraint#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
  void setRightOperand(ValueReference value);

} // CompareConstraint
