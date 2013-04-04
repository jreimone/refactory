/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMFPatternLanguageFactoryImpl extends EFactoryImpl implements EMFPatternLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EMFPatternLanguageFactory init()
  {
    try
    {
      EMFPatternLanguageFactory theEMFPatternLanguageFactory = (EMFPatternLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/incquery/patternlanguage/emf/EMFPatternLanguage"); 
      if (theEMFPatternLanguageFactory != null)
      {
        return theEMFPatternLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EMFPatternLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMFPatternLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case EMFPatternLanguagePackage.IMPORT_DECLARATION: return createImportDeclaration();
      case EMFPatternLanguagePackage.PACKAGE_IMPORT: return createPackageImport();
      case EMFPatternLanguagePackage.JAVA_IMPORT: return createJavaImport();
      case EMFPatternLanguagePackage.ECLASSIFIER_CONSTRAINT: return createEClassifierConstraint();
      case EMFPatternLanguagePackage.ENUM_VALUE: return createEnumValue();
      case EMFPatternLanguagePackage.PATTERN_MODEL: return createPatternModel();
      case EMFPatternLanguagePackage.CLASS_TYPE: return createClassType();
      case EMFPatternLanguagePackage.REFERENCE_TYPE: return createReferenceType();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportDeclaration createImportDeclaration()
  {
    ImportDeclarationImpl importDeclaration = new ImportDeclarationImpl();
    return importDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageImport createPackageImport()
  {
    PackageImportImpl packageImport = new PackageImportImpl();
    return packageImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaImport createJavaImport()
  {
    JavaImportImpl javaImport = new JavaImportImpl();
    return javaImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifierConstraint createEClassifierConstraint()
  {
    EClassifierConstraintImpl eClassifierConstraint = new EClassifierConstraintImpl();
    return eClassifierConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumValue createEnumValue()
  {
    EnumValueImpl enumValue = new EnumValueImpl();
    return enumValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternModel createPatternModel()
  {
    PatternModelImpl patternModel = new PatternModelImpl();
    return patternModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassType createClassType()
  {
    ClassTypeImpl classType = new ClassTypeImpl();
    return classType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceType createReferenceType()
  {
    ReferenceTypeImpl referenceType = new ReferenceTypeImpl();
    return referenceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMFPatternLanguagePackage getEMFPatternLanguagePackage()
  {
    return (EMFPatternLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EMFPatternLanguagePackage getPackage()
  {
    return EMFPatternLanguagePackage.eINSTANCE;
  }

} //EMFPatternLanguageFactoryImpl
