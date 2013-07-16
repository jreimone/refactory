/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImport Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.XImportSection#getPackageImport <em>Package Import</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getXImportSection()
 * @model
 * @generated
 */
public interface XImportSection extends org.eclipse.xtext.xtype.XImportSection
{
  /**
   * Returns the value of the '<em><b>Package Import</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package Import</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package Import</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage#getXImportSection_PackageImport()
   * @model containment="true"
   * @generated
   */
  EList<PackageImport> getPackageImport();

} // XImportSection
