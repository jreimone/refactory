/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement;
import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Expression Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionElementImpl#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathExpressionElementImpl extends MinimalEObjectImpl.Container implements PathExpressionElement
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

  /**
   * The cached value of the '{@link #getTail() <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTail()
   * @generated
   * @ordered
   */
  protected PathExpressionTail tail;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PathExpressionElementImpl()
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
    return PatternLanguagePackage.Literals.PATH_EXPRESSION_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(Type newType, NotificationChain msgs)
  {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE, oldType, newType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Type newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathExpressionTail getTail()
  {
    return tail;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTail(PathExpressionTail newTail, NotificationChain msgs)
  {
    PathExpressionTail oldTail = tail;
    tail = newTail;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL, oldTail, newTail);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTail(PathExpressionTail newTail)
  {
    if (newTail != tail)
    {
      NotificationChain msgs = null;
      if (tail != null)
        msgs = ((InternalEObject)tail).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL, null, msgs);
      if (newTail != null)
        msgs = ((InternalEObject)newTail).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL, null, msgs);
      msgs = basicSetTail(newTail, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL, newTail, newTail));
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
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE:
        return basicSetType(null, msgs);
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL:
        return basicSetTail(null, msgs);
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
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE:
        return getType();
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL:
        return getTail();
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
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE:
        setType((Type)newValue);
        return;
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL:
        setTail((PathExpressionTail)newValue);
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
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE:
        setType((Type)null);
        return;
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL:
        setTail((PathExpressionTail)null);
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
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TYPE:
        return type != null;
      case PatternLanguagePackage.PATH_EXPRESSION_ELEMENT__TAIL:
        return tail != null;
    }
    return super.eIsSet(featureID);
  }

} //PathExpressionElementImpl
