/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.*;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.EntityType;
import org.eclipse.incquery.patternlanguage.patternLanguage.RelationType;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage
 * @generated
 */
public class EMFPatternLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EMFPatternLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EMFPatternLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = EMFPatternLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case EMFPatternLanguagePackage.XIMPORT_SECTION:
      {
        XImportSection xImportSection = (XImportSection)theEObject;
        T result = caseXImportSection(xImportSection);
        if (result == null) result = caseXtype_XImportSection(xImportSection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EMFPatternLanguagePackage.PACKAGE_IMPORT:
      {
        PackageImport packageImport = (PackageImport)theEObject;
        T result = casePackageImport(packageImport);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EMFPatternLanguagePackage.ECLASSIFIER_CONSTRAINT:
      {
        EClassifierConstraint eClassifierConstraint = (EClassifierConstraint)theEObject;
        T result = caseEClassifierConstraint(eClassifierConstraint);
        if (result == null) result = caseConstraint(eClassifierConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EMFPatternLanguagePackage.ENUM_VALUE:
      {
        EnumValue enumValue = (EnumValue)theEObject;
        T result = caseEnumValue(enumValue);
        if (result == null) result = caseValueReference(enumValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EMFPatternLanguagePackage.PATTERN_MODEL:
      {
        PatternModel patternModel = (PatternModel)theEObject;
        T result = casePatternModel(patternModel);
        if (result == null) result = casePatternLanguage_PatternModel(patternModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EMFPatternLanguagePackage.CLASS_TYPE:
      {
        ClassType classType = (ClassType)theEObject;
        T result = caseClassType(classType);
        if (result == null) result = caseEntityType(classType);
        if (result == null) result = caseType(classType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case EMFPatternLanguagePackage.REFERENCE_TYPE:
      {
        ReferenceType referenceType = (ReferenceType)theEObject;
        T result = caseReferenceType(referenceType);
        if (result == null) result = caseRelationType(referenceType);
        if (result == null) result = caseType(referenceType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XImport Section</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XImport Section</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXImportSection(XImportSection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageImport(PackageImport object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EClassifier Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EClassifier Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEClassifierConstraint(EClassifierConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumValue(EnumValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternModel(PatternModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassType(ClassType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceType(ReferenceType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XImport Section</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XImport Section</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXtype_XImportSection(org.eclipse.xtext.xtype.XImportSection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraint(Constraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueReference(ValueReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternLanguage_PatternModel(org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntityType(EntityType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relation Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relation Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationType(RelationType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //EMFPatternLanguageSwitch
