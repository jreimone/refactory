/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;

import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.incquery.patternlanguage.patternLanguage.EntityType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType#getClassname <em>Classname</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getClassType()
 * @model
 * @generated
 */
public interface ClassType extends EntityType
{
  /**
   * Returns the value of the '<em><b>Classname</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classname</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classname</em>' reference.
   * @see #setClassname(EClassifier)
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getClassType_Classname()
   * @model
   * @generated
   */
  EClassifier getClassname();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType#getClassname <em>Classname</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Classname</em>' reference.
   * @see #getClassname()
   * @generated
   */
  void setClassname(EClassifier value);

} // ClassType
