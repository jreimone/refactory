/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Expression Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getSrc <em>Src</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getDst <em>Dst</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionHead()
 * @model
 * @generated
 */
public interface PathExpressionHead extends PathExpressionElement
{
  /**
	 * Returns the value of the '<em><b>Src</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Src</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' containment reference.
	 * @see #setSrc(VariableReference)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionHead_Src()
	 * @model containment="true"
	 * @generated
	 */
  VariableReference getSrc();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getSrc <em>Src</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' containment reference.
	 * @see #getSrc()
	 * @generated
	 */
  void setSrc(VariableReference value);

  /**
	 * Returns the value of the '<em><b>Dst</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dst</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst</em>' containment reference.
	 * @see #setDst(ValueReference)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPathExpressionHead_Dst()
	 * @model containment="true"
	 * @generated
	 */
  ValueReference getDst();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionHead#getDst <em>Dst</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dst</em>' containment reference.
	 * @see #getDst()
	 * @generated
	 */
  void setDst(ValueReference value);

} // PathExpressionHead
