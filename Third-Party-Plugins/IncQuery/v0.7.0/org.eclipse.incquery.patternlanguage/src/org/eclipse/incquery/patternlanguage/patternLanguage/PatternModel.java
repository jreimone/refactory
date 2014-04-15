/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel#getPatterns <em>Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternModel()
 * @model
 * @generated
 */
public interface PatternModel extends EObject
{
  /**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternModel_PackageName()
	 * @model
	 * @generated
	 */
  String getPackageName();

  /**
	 * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
  void setPackageName(String value);

  /**
	 * Returns the value of the '<em><b>Patterns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.incquery.patternlanguage.patternLanguage.Pattern}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Patterns</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Patterns</em>' containment reference list.
	 * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage#getPatternModel_Patterns()
	 * @model containment="true"
	 * @generated
	 */
  EList<Pattern> getPatterns();

} // PatternModel
