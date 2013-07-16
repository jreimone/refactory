/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.Type#getTypename <em>Typename</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getType()
 * @model
 * @generated
 */
public interface Type extends EObject
{
  /**
   * Returns the value of the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Typename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typename</em>' attribute.
   * @see #setTypename(String)
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getType_Typename()
   * @model transient="true"
   * @generated
   */
  String getTypename();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Type#getTypename <em>Typename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Typename</em>' attribute.
   * @see #getTypename()
   * @generated
   */
  void setTypename(String value);

} // Type
