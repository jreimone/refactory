/**
 */
package org.eclipse.incquery.patternlanguage.patternLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternCall;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCallImpl#getPatternRef <em>Pattern Ref</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCallImpl#isTransitive <em>Transitive</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternCallImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternCallImpl extends MinimalEObjectImpl.Container implements PatternCall
{
  /**
   * The cached value of the '{@link #getPatternRef() <em>Pattern Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPatternRef()
   * @generated
   * @ordered
   */
  protected Pattern patternRef;

  /**
   * The default value of the '{@link #isTransitive() <em>Transitive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransitive()
   * @generated
   * @ordered
   */
  protected static final boolean TRANSITIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTransitive() <em>Transitive</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTransitive()
   * @generated
   * @ordered
   */
  protected boolean transitive = TRANSITIVE_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ValueReference> parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternCallImpl()
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
    return PatternLanguagePackage.Literals.PATTERN_CALL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern getPatternRef()
  {
    if (patternRef != null && patternRef.eIsProxy())
    {
      InternalEObject oldPatternRef = (InternalEObject)patternRef;
      patternRef = (Pattern)eResolveProxy(oldPatternRef);
      if (patternRef != oldPatternRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternLanguagePackage.PATTERN_CALL__PATTERN_REF, oldPatternRef, patternRef));
      }
    }
    return patternRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern basicGetPatternRef()
  {
    return patternRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPatternRef(Pattern newPatternRef)
  {
    Pattern oldPatternRef = patternRef;
    patternRef = newPatternRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATTERN_CALL__PATTERN_REF, oldPatternRef, patternRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTransitive()
  {
    return transitive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransitive(boolean newTransitive)
  {
    boolean oldTransitive = transitive;
    transitive = newTransitive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PatternLanguagePackage.PATTERN_CALL__TRANSITIVE, oldTransitive, transitive));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValueReference> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<ValueReference>(ValueReference.class, this, PatternLanguagePackage.PATTERN_CALL__PARAMETERS);
    }
    return parameters;
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
      case PatternLanguagePackage.PATTERN_CALL__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
      case PatternLanguagePackage.PATTERN_CALL__PATTERN_REF:
        if (resolve) return getPatternRef();
        return basicGetPatternRef();
      case PatternLanguagePackage.PATTERN_CALL__TRANSITIVE:
        return isTransitive();
      case PatternLanguagePackage.PATTERN_CALL__PARAMETERS:
        return getParameters();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PatternLanguagePackage.PATTERN_CALL__PATTERN_REF:
        setPatternRef((Pattern)newValue);
        return;
      case PatternLanguagePackage.PATTERN_CALL__TRANSITIVE:
        setTransitive((Boolean)newValue);
        return;
      case PatternLanguagePackage.PATTERN_CALL__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ValueReference>)newValue);
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
      case PatternLanguagePackage.PATTERN_CALL__PATTERN_REF:
        setPatternRef((Pattern)null);
        return;
      case PatternLanguagePackage.PATTERN_CALL__TRANSITIVE:
        setTransitive(TRANSITIVE_EDEFAULT);
        return;
      case PatternLanguagePackage.PATTERN_CALL__PARAMETERS:
        getParameters().clear();
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
      case PatternLanguagePackage.PATTERN_CALL__PATTERN_REF:
        return patternRef != null;
      case PatternLanguagePackage.PATTERN_CALL__TRANSITIVE:
        return transitive != TRANSITIVE_EDEFAULT;
      case PatternLanguagePackage.PATTERN_CALL__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
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
    result.append(" (transitive: ");
    result.append(transitive);
    result.append(')');
    return result.toString();
  }

} //PatternCallImpl
