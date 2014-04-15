/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionTail;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Expression Tail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionTailImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PathExpressionTailImpl#isClosure <em>Closure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathExpressionTailImpl extends PathExpressionElementImpl implements PathExpressionTail
{
  /**
   * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected static final int INDEX_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIndex()
   * @generated
   * @ordered
   */
  protected int index = INDEX_EDEFAULT;

  /**
   * The default value of the '{@link #isClosure() <em>Closure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isClosure()
   * @generated
   * @ordered
   */
  protected static final boolean CLOSURE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isClosure() <em>Closure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isClosure()
   * @generated
   * @ordered
   */
  protected boolean closure = CLOSURE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PathExpressionTailImpl()
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
    return PatternLanguagePackage.Literals.PATH_EXPRESSION_TAIL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getIndex()
  {
    return index;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIndex(int newIndex)
  {
    int oldIndex = index;
    index = newIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATH_EXPRESSION_TAIL__INDEX, oldIndex, index));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isClosure()
  {
    return closure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClosure(boolean newClosure)
  {
    boolean oldClosure = closure;
    closure = newClosure;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATH_EXPRESSION_TAIL__CLOSURE, oldClosure, closure));
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
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__INDEX:
        return getIndex();
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__CLOSURE:
        return isClosure();
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
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__INDEX:
        setIndex((Integer)newValue);
        return;
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__CLOSURE:
        setClosure((Boolean)newValue);
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
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__INDEX:
        setIndex(INDEX_EDEFAULT);
        return;
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__CLOSURE:
        setClosure(CLOSURE_EDEFAULT);
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
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__INDEX:
        return index != INDEX_EDEFAULT;
      case PatternLanguagePackage.PATH_EXPRESSION_TAIL__CLOSURE:
        return closure != CLOSURE_EDEFAULT;
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
    result.append(" (index: ");
    result.append(index);
    result.append(", closure: ");
    result.append(closure);
    result.append(')');
    return result.toString();
  }

} //PathExpressionTailImpl
