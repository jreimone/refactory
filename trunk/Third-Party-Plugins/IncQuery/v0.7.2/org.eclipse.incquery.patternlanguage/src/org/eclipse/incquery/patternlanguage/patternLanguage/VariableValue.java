/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariableValue()
 * @model
 * @generated
 */
public interface VariableValue extends ValueReference
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(VariableReference)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getVariableValue_Value()
   * @model containment="true"
   * @generated
   */
  VariableReference getValue();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.VariableValue#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(VariableReference value);

} // VariableValue
