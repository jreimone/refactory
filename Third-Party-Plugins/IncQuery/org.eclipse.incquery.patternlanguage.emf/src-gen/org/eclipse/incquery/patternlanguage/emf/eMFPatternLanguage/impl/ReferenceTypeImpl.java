/**
 */
package org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.EMFPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.ReferenceType;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.RelationTypeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.emf.eMFPatternLanguage.impl.ReferenceTypeImpl#getRefname <em>Refname</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceTypeImpl extends RelationTypeImpl implements ReferenceType
{
  /**
   * The cached value of the '{@link #getRefname() <em>Refname</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefname()
   * @generated
   * @ordered
   */
  protected EStructuralFeature refname;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReferenceTypeImpl()
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
    return EMFPatternLanguagePackage.Literals.REFERENCE_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EStructuralFeature getRefname()
  {
    if (refname != null && refname.eIsProxy())
    {
      InternalEObject oldRefname = (InternalEObject)refname;
      refname = (EStructuralFeature)eResolveProxy(oldRefname);
      if (refname != oldRefname)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EMFPatternLanguagePackage.REFERENCE_TYPE__REFNAME, oldRefname, refname));
      }
    }
    return refname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EStructuralFeature basicGetRefname()
  {
    return refname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefname(EStructuralFeature newRefname)
  {
    EStructuralFeature oldRefname = refname;
    refname = newRefname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EMFPatternLanguagePackage.REFERENCE_TYPE__REFNAME, oldRefname, refname));
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
      case EMFPatternLanguagePackage.REFERENCE_TYPE__REFNAME:
        if (resolve) return getRefname();
        return basicGetRefname();
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
      case EMFPatternLanguagePackage.REFERENCE_TYPE__REFNAME:
        setRefname((EStructuralFeature)newValue);
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
      case EMFPatternLanguagePackage.REFERENCE_TYPE__REFNAME:
        setRefname((EStructuralFeature)null);
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
      case EMFPatternLanguagePackage.REFERENCE_TYPE__REFNAME:
        return refname != null;
    }
    return super.eIsSet(featureID);
  }

} //ReferenceTypeImpl
