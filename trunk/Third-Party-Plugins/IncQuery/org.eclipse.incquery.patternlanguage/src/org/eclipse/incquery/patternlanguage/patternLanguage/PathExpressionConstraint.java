/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Expression Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint#getHead <em>Head</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionConstraint()
 * @model
 * @generated
 */
public interface PathExpressionConstraint extends Constraint
{
  /**
   * Returns the value of the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Head</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Head</em>' containment reference.
   * @see #setHead(PathExpressionHead)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionConstraint_Head()
   * @model containment="true"
   * @generated
   */
  PathExpressionHead getHead();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionConstraint#getHead <em>Head</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Head</em>' containment reference.
   * @see #getHead()
   * @generated
   */
  void setHead(PathExpressionHead value);

} // PathExpressionConstraint
