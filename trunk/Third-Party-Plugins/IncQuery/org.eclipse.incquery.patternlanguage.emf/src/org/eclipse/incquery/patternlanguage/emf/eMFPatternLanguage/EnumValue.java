/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getEnumValue()
 * @model
 * @generated
 */
public interface EnumValue extends ValueReference
{
  /**
   * Returns the value of the '<em><b>Enumeration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration</em>' reference.
   * @see #setEnumeration(EEnum)
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getEnumValue_Enumeration()
   * @model
   * @generated
   */
  EEnum getEnumeration();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getEnumeration <em>Enumeration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration</em>' reference.
   * @see #getEnumeration()
   * @generated
   */
  void setEnumeration(EEnum value);

  /**
   * Returns the value of the '<em><b>Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literal</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literal</em>' reference.
   * @see #setLiteral(EEnumLiteral)
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getEnumValue_Literal()
   * @model
   * @generated
   */
  EEnumLiteral getLiteral();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getLiteral <em>Literal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Literal</em>' reference.
   * @see #getLiteral()
   * @generated
   */
  void setLiteral(EEnumLiteral value);

} // EnumValue
