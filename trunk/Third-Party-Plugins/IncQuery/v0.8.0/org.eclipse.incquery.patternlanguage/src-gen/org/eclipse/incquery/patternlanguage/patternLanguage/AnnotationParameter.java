/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getAnnotationParameter()
 * @model
 * @generated
 */
public interface AnnotationParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getAnnotationParameter_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueReference)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getAnnotationParameter_Value()
   * @model containment="true"
   * @generated
   */
  ValueReference getValue();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.AnnotationParameter#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueReference value);

} // AnnotationParameter
