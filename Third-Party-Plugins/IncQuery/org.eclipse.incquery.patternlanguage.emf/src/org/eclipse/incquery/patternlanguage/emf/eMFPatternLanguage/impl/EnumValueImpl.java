/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EnumValue;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.ValueReferenceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EnumValueImpl#getEnumeration <em>Enumeration</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.EnumValueImpl#getLiteral <em>Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumValueImpl extends ValueReferenceImpl implements EnumValue
{
  /**
   * The cached value of the '{@link #getEnumeration() <em>Enumeration</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumeration()
   * @generated
   * @ordered
   */
  protected EEnum enumeration;

  /**
   * The cached value of the '{@link #getLiteral() <em>Literal</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLiteral()
   * @generated
   * @ordered
   */
  protected EEnumLiteral literal;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumValueImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EMFPatternLanguagePackage.Literals.ENUM_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getEnumeration()
  {
    if (enumeration != null && enumeration.eIsProxy())
    {
      InternalEObject oldEnumeration = (InternalEObject)enumeration;
      enumeration = (EEnum)eResolveProxy(oldEnumeration);
      if (enumeration != oldEnumeration)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMFPatternLanguagePackage.ENUM_VALUE__ENUMERATION, oldEnumeration, enumeration));
      }
    }
    return enumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum basicGetEnumeration()
  {
    return enumeration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumeration(EEnum newEnumeration)
  {
    EEnum oldEnumeration = enumeration;
    enumeration = newEnumeration;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EMFPatternLanguagePackage.ENUM_VALUE__ENUMERATION, oldEnumeration, enumeration));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnumLiteral getLiteral()
  {
    if (literal != null && literal.eIsProxy())
    {
      InternalEObject oldLiteral = (InternalEObject)literal;
      literal = (EEnumLiteral)eResolveProxy(oldLiteral);
      if (literal != oldLiteral)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMFPatternLanguagePackage.ENUM_VALUE__LITERAL, oldLiteral, literal));
      }
    }
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnumLiteral basicGetLiteral()
  {
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLiteral(EEnumLiteral newLiteral)
  {
    EEnumLiteral oldLiteral = literal;
    literal = newLiteral;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EMFPatternLanguagePackage.ENUM_VALUE__LITERAL, oldLiteral, literal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EMFPatternLanguagePackage.ENUM_VALUE__ENUMERATION:
        if (resolve) return getEnumeration();
        return basicGetEnumeration();
      case EMFPatternLanguagePackage.ENUM_VALUE__LITERAL:
        if (resolve) return getLiteral();
        return basicGetLiteral();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EMFPatternLanguagePackage.ENUM_VALUE__ENUMERATION:
        setEnumeration((EEnum)newValue);
        return;
      case EMFPatternLanguagePackage.ENUM_VALUE__LITERAL:
        setLiteral((EEnumLiteral)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EMFPatternLanguagePackage.ENUM_VALUE__ENUMERATION:
        setEnumeration((EEnum)null);
        return;
      case EMFPatternLanguagePackage.ENUM_VALUE__LITERAL:
        setLiteral((EEnumLiteral)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EMFPatternLanguagePackage.ENUM_VALUE__ENUMERATION:
        return enumeration != null;
      case EMFPatternLanguagePackage.ENUM_VALUE__LITERAL:
        return literal != null;
    }
    return super.eIsSet(featureID);
  }

} //EnumValueImpl
