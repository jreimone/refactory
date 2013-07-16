/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCompositionConstraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Composition Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCompositionConstraintImpl#isNegative <em>Negative</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCompositionConstraintImpl#getCall <em>Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternCompositionConstraintImpl extends ConstraintImpl implements PatternCompositionConstraint
{
  /**
   * The default value of the '{@link #isNegative() <em>Negative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNegative()
   * @generated
   * @ordered
   */
  protected static final boolean NEGATIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNegative() <em>Negative</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNegative()
   * @generated
   * @ordered
   */
  protected boolean negative = NEGATIVE_EDEFAULT;

  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected PatternCall call;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternCompositionConstraintImpl()
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
    return PatternLanguagePackage.Literals.PATTERN_COMPOSITION_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNegative()
  {
    return negative;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNegative(boolean newNegative)
  {
    boolean oldNegative = negative;
    negative = newNegative;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__NEGATIVE, oldNegative, negative));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternCall getCall()
  {
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCall(PatternCall newCall, NotificationChain msgs)
  {
    PatternCall oldCall = call;
    call = newCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL, oldCall, newCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall(PatternCall newCall)
  {
    if (newCall != call)
    {
      NotificationChain msgs = null;
      if (call != null)
        msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL, null, msgs);
      if (newCall != null)
        msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL, null, msgs);
      msgs = basicSetCall(newCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL, newCall, newCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL:
        return basicSetCall(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__NEGATIVE:
        return isNegative();
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL:
        return getCall();
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
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__NEGATIVE:
        setNegative((Boolean)newValue);
        return;
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL:
        setCall((PatternCall)newValue);
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
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__NEGATIVE:
        setNegative(NEGATIVE_EDEFAULT);
        return;
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL:
        setCall((PatternCall)null);
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
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__NEGATIVE:
        return negative != NEGATIVE_EDEFAULT;
      case PatternLanguagePackage.PATTERN_COMPOSITION_CONSTRAINT__CALL:
        return call != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (negative: ");
    result.append(negative);
    result.append(')');
    return result.toString();
  }

} //PatternCompositionConstraintImpl
