/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.ParameterRef;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.patternLanguage.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.ParameterRefImpl#getReferredParam <em>Referred Param</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterRefImpl extends VariableImpl implements ParameterRef
{
  /**
   * The cached value of the '{@link #getReferredParam() <em>Referred Param</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferredParam()
   * @generated
   * @ordered
   */
  protected Variable referredParam;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ParameterRefImpl()
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
    return PatternLanguagePackage.Literals.PARAMETER_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable getReferredParam()
  {
    if (referredParam != null && referredParam.eIsProxy())
    {
      InternalEObject oldReferredParam = (InternalEObject)referredParam;
      referredParam = (Variable)eResolveProxy(oldReferredParam);
      if (referredParam != oldReferredParam)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternLanguagePackage.PARAMETER_REF__REFERRED_PARAM, oldReferredParam, referredParam));
      }
    }
    return referredParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable basicGetReferredParam()
  {
    return referredParam;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferredParam(Variable newReferredParam)
  {
    Variable oldReferredParam = referredParam;
    referredParam = newReferredParam;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PARAMETER_REF__REFERRED_PARAM, oldReferredParam, referredParam));
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
      case PatternLanguagePackage.PARAMETER_REF__REFERRED_PARAM:
        if (resolve) return getReferredParam();
        return basicGetReferredParam();
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
      case PatternLanguagePackage.PARAMETER_REF__REFERRED_PARAM:
        setReferredParam((Variable)newValue);
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
      case PatternLanguagePackage.PARAMETER_REF__REFERRED_PARAM:
        setReferredParam((Variable)null);
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
      case PatternLanguagePackage.PARAMETER_REF__REFERRED_PARAM:
        return referredParam != null;
    }
    return super.eIsSet(featureID);
  }

} //ParameterRefImpl
