/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Expression Tail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#isClosure <em>Closure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionTail()
 * @model
 * @generated
 */
public interface PathExpressionTail extends PathExpressionElement
{
  /**
   * Returns the value of the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' attribute.
   * @see #setIndex(int)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionTail_Index()
   * @model
   * @generated
   */
  int getIndex();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#getIndex <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' attribute.
   * @see #getIndex()
   * @generated
   */
  void setIndex(int value);

  /**
   * Returns the value of the '<em><b>Closure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Closure</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Closure</em>' attribute.
   * @see #setClosure(boolean)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionTail_Closure()
   * @model
   * @generated
   */
  boolean isClosure();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail#isClosure <em>Closure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Closure</em>' attribute.
   * @see #isClosure()
   * @generated
   */
  void setClosure(boolean value);

} // PathExpressionTail
