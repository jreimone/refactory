/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;

import org.eclipse.emf.common.util.EList;

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
   * Returns the value of the '<em><b>Import Packages</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ImportDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Packages</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getPatternModel_ImportPackages()
   * @model containment="true"
   * @generated
   */
  EList<ImportDeclaration> getImportPackages();

} // PatternModel
