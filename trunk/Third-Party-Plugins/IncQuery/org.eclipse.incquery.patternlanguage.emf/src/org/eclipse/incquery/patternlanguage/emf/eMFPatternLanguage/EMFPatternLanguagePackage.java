/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

import org.eclipse.xtext.xtype.XtypePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface EMFPatternLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "eMFPatternLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/incquery/patternlanguage/emf/EMFPatternLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "eMFPatternLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EMFPatternLanguagePackage eINSTANCE = org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.XImportSectionImpl <em>XImport Section</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.XImportSectionImpl
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getXImportSection()
   * @generated
   */
  int XIMPORT_SECTION = 0;

  /**
   * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XIMPORT_SECTION__IMPORT_DECLARATIONS = XtypePackage.XIMPORT_SECTION__IMPORT_DECLARATIONS;

  /**
   * The feature id for the '<em><b>Package Import</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XIMPORT_SECTION__PACKAGE_IMPORT = XtypePackage.XIMPORT_SECTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XImport Section</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XIMPORT_SECTION_FEATURE_COUNT = XtypePackage.XIMPORT_SECTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PackageImportImpl <em>Package Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PackageImportImpl
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getPackageImport()
   * @generated
   */
  int PACKAGE_IMPORT = 1;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_IMPORT__EPACKAGE = 0;

  /**
   * The number of structural features of the '<em>Package Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EClassifierConstraintImpl <em>EClassifier Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EClassifierConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getEClassifierConstraint()
   * @generated
   */
  int ECLASSIFIER_CONSTRAINT = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECLASSIFIER_CONSTRAINT__TYPE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECLASSIFIER_CONSTRAINT__VAR = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>EClassifier Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECLASSIFIER_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EnumValueImpl <em>Enum Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EnumValueImpl
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getEnumValue()
   * @generated
   */
  int ENUM_VALUE = 3;

  /**
   * The feature id for the '<em><b>Enumeration</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE__ENUMERATION = PatternLanguagePackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Literal</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE__LITERAL = PatternLanguagePackage.VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enum Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE_FEATURE_COUNT = PatternLanguagePackage.VALUE_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PatternModelImpl <em>Pattern Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PatternModelImpl
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getPatternModel()
   * @generated
   */
  int PATTERN_MODEL = 4;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PACKAGE_NAME = PatternLanguagePackage.PATTERN_MODEL__PACKAGE_NAME;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PATTERNS = PatternLanguagePackage.PATTERN_MODEL__PATTERNS;

  /**
   * The feature id for the '<em><b>Import Packages</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__IMPORT_PACKAGES = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pattern Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL_FEATURE_COUNT = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ClassTypeImpl <em>Class Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ClassTypeImpl
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getClassType()
   * @generated
   */
  int CLASS_TYPE = 5;

  /**
   * The feature id for the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE__TYPENAME = PatternLanguagePackage.ENTITY_TYPE__TYPENAME;

  /**
   * The feature id for the '<em><b>Classname</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE__CLASSNAME = PatternLanguagePackage.ENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Class Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_TYPE_FEATURE_COUNT = PatternLanguagePackage.ENTITY_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ReferenceTypeImpl
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getReferenceType()
   * @generated
   */
  int REFERENCE_TYPE = 6;

  /**
   * The feature id for the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE__TYPENAME = PatternLanguagePackage.RELATION_TYPE__TYPENAME;

  /**
   * The feature id for the '<em><b>Refname</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE__REFNAME = PatternLanguagePackage.RELATION_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_TYPE_FEATURE_COUNT = PatternLanguagePackage.RELATION_TYPE_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.XImportSection <em>XImport Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XImport Section</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.XImportSection
   * @generated
   */
  EClass getXImportSection();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.XImportSection#getPackageImport <em>Package Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Package Import</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.XImportSection#getPackageImport()
   * @see #getXImportSection()
   * @generated
   */
  EReference getXImportSection_PackageImport();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport <em>Package Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Import</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport
   * @generated
   */
  EClass getPackageImport();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PackageImport#getEPackage()
   * @see #getPackageImport()
   * @generated
   */
  EReference getPackageImport_EPackage();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EClassifierConstraint <em>EClassifier Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EClassifier Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EClassifierConstraint
   * @generated
   */
  EClass getEClassifierConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EClassifierConstraint#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EClassifierConstraint#getType()
   * @see #getEClassifierConstraint()
   * @generated
   */
  EReference getEClassifierConstraint_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EClassifierConstraint#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EClassifierConstraint#getVar()
   * @see #getEClassifierConstraint()
   * @generated
   */
  EReference getEClassifierConstraint_Var();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue
   * @generated
   */
  EClass getEnumValue();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getEnumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Enumeration</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getEnumeration()
   * @see #getEnumValue()
   * @generated
   */
  EReference getEnumValue_Enumeration();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getLiteral <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Literal</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue#getLiteral()
   * @see #getEnumValue()
   * @generated
   */
  EReference getEnumValue_Literal();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Model</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel
   * @generated
   */
  EClass getPatternModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel#getImportPackages <em>Import Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Packages</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.PatternModel#getImportPackages()
   * @see #getPatternModel()
   * @generated
   */
  EReference getPatternModel_ImportPackages();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType <em>Class Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType
   * @generated
   */
  EClass getClassType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType#getClassname <em>Classname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Classname</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ClassType#getClassname()
   * @see #getClassType()
   * @generated
   */
  EReference getClassType_Classname();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType
   * @generated
   */
  EClass getReferenceType();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType#getRefname <em>Refname</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Refname</em>'.
   * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType#getRefname()
   * @see #getReferenceType()
   * @generated
   */
  EReference getReferenceType_Refname();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EMFPatternLanguageFactory getEMFPatternLanguageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.XImportSectionImpl <em>XImport Section</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.XImportSectionImpl
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getXImportSection()
     * @generated
     */
    EClass XIMPORT_SECTION = eINSTANCE.getXImportSection();

    /**
     * The meta object literal for the '<em><b>Package Import</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XIMPORT_SECTION__PACKAGE_IMPORT = eINSTANCE.getXImportSection_PackageImport();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PackageImportImpl <em>Package Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PackageImportImpl
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getPackageImport()
     * @generated
     */
    EClass PACKAGE_IMPORT = eINSTANCE.getPackageImport();

    /**
     * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_IMPORT__EPACKAGE = eINSTANCE.getPackageImport_EPackage();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EClassifierConstraintImpl <em>EClassifier Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EClassifierConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getEClassifierConstraint()
     * @generated
     */
    EClass ECLASSIFIER_CONSTRAINT = eINSTANCE.getEClassifierConstraint();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ECLASSIFIER_CONSTRAINT__TYPE = eINSTANCE.getEClassifierConstraint_Type();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ECLASSIFIER_CONSTRAINT__VAR = eINSTANCE.getEClassifierConstraint_Var();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EnumValueImpl <em>Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EnumValueImpl
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getEnumValue()
     * @generated
     */
    EClass ENUM_VALUE = eINSTANCE.getEnumValue();

    /**
     * The meta object literal for the '<em><b>Enumeration</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_VALUE__ENUMERATION = eINSTANCE.getEnumValue_Enumeration();

    /**
     * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_VALUE__LITERAL = eINSTANCE.getEnumValue_Literal();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PatternModelImpl <em>Pattern Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.PatternModelImpl
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getPatternModel()
     * @generated
     */
    EClass PATTERN_MODEL = eINSTANCE.getPatternModel();

    /**
     * The meta object literal for the '<em><b>Import Packages</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_MODEL__IMPORT_PACKAGES = eINSTANCE.getPatternModel_ImportPackages();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ClassTypeImpl <em>Class Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ClassTypeImpl
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getClassType()
     * @generated
     */
    EClass CLASS_TYPE = eINSTANCE.getClassType();

    /**
     * The meta object literal for the '<em><b>Classname</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_TYPE__CLASSNAME = eINSTANCE.getClassType_Classname();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ReferenceTypeImpl <em>Reference Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ReferenceTypeImpl
     * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EMFPatternLanguagePackageImpl#getReferenceType()
     * @generated
     */
    EClass REFERENCE_TYPE = eINSTANCE.getReferenceType();

    /**
     * The meta object literal for the '<em><b>Refname</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_TYPE__REFNAME = eINSTANCE.getReferenceType_Refname();

  }

} //EMFPatternLanguagePackage
