/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel#getImportPackages <em>Import Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getPatternModel()
 * @model
 * @generated
 */
public interface PatternModel extends org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
{
  /**
   * Returns the value of the '<em><b>Import Packages</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Packages</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Packages</em>' containment reference.
   * @see #setImportPackages(XImportSection)
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getPatternModel_ImportPackages()
   * @model containment="true"
   * @generated
   */
  XImportSection getImportPackages();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel#getImportPackages <em>Import Packages</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Packages</em>' containment reference.
   * @see #getImportPackages()
   * @generated
   */
  void setImportPackages(XImportSection value);

} // PatternModel
