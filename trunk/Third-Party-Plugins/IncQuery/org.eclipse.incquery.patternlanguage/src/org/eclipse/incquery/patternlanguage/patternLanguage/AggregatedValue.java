/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregated Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getAggregator <em>Aggregator</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getCall <em>Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getAggregatedValue()
 * @model
 * @generated
 */
public interface AggregatedValue extends ComputationValue
{
  /**
   * Returns the value of the '<em><b>Aggregator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Aggregator</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Aggregator</em>' containment reference.
   * @see #setAggregator(AggregatorExpression)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getAggregatedValue_Aggregator()
   * @model containment="true"
   * @generated
   */
  AggregatorExpression getAggregator();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getAggregator <em>Aggregator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Aggregator</em>' containment reference.
   * @see #getAggregator()
   * @generated
   */
  void setAggregator(AggregatorExpression value);

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
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getAggregatedValue_Call()
   * @model containment="true"
   * @generated
   */
  PatternCall getCall();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AggregatedValue#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(PatternCall value);

} // AggregatedValue
