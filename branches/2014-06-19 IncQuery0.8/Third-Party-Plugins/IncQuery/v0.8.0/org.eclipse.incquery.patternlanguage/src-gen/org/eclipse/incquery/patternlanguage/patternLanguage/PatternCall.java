/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#getPatternRef <em>Pattern Ref</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#isTransitive <em>Transitive</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternCall()
 * @model
 * @generated
 */
public interface PatternCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Pattern Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pattern Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern Ref</em>' reference.
   * @see #setPatternRef(Pattern)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternCall_PatternRef()
   * @model
   * @generated
   */
  Pattern getPatternRef();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#getPatternRef <em>Pattern Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern Ref</em>' reference.
   * @see #getPatternRef()
   * @generated
   */
  void setPatternRef(Pattern value);

  /**
   * Returns the value of the '<em><b>Transitive</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitive</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transitive</em>' attribute.
   * @see #setTransitive(boolean)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternCall_Transitive()
   * @model
   * @generated
   */
  boolean isTransitive();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall#isTransitive <em>Transitive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transitive</em>' attribute.
   * @see #isTransitive()
   * @generated
   */
  void setTransitive(boolean value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternCall_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<ValueReference> getParameters();

} // PatternCall
