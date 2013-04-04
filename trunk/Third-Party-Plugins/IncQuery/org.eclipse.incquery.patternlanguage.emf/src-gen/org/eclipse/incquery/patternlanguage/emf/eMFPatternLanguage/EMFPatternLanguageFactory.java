/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage
 * @generated
 */
public interface EMFPatternLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EMFPatternLanguageFactory eINSTANCE = org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Import Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Declaration</em>'.
   * @generated
   */
  ImportDeclaration createImportDeclaration();

  /**
   * Returns a new object of class '<em>Package Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Import</em>'.
   * @generated
   */
  PackageImport createPackageImport();

  /**
   * Returns a new object of class '<em>Java Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java Import</em>'.
   * @generated
   */
  JavaImport createJavaImport();

  /**
   * Returns a new object of class '<em>EClassifier Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EClassifier Constraint</em>'.
   * @generated
   */
  EClassifierConstraint createEClassifierConstraint();

  /**
   * Returns a new object of class '<em>Enum Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Value</em>'.
   * @generated
   */
  EnumValue createEnumValue();

  /**
   * Returns a new object of class '<em>Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern Model</em>'.
   * @generated
   */
  PatternModel createPatternModel();

  /**
   * Returns a new object of class '<em>Class Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Type</em>'.
   * @generated
   */
  ClassType createClassType();

  /**
   * Returns a new object of class '<em>Reference Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reference Type</em>'.
   * @generated
   */
  ReferenceType createReferenceType();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EMFPatternLanguagePackage getEMFPatternLanguagePackage();

} //EMFPatternLanguageFactory
